package display;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import gui.FiguresUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import handlers.Main;
/**
 * Created by Admin on 22.02.2016.
 */
public class GLDisplay {
    private static final int DEFAULT_WIDTH = 640;
    private static final int DEFAULT_HEIGHT = 480;

    private static final int DONT_CARE = -1;

    private FiguresUI frame;
    private GLCanvas glCanvas;
    private FPSAnimator animator;
    private boolean fullscreen;
    private int width;
    private int height;
    private GraphicsDevice usedDevice;
    public static float scale = 1.0f;

    private MyHelpOverlayGLEventListener helpOverlayGLEventListener = new MyHelpOverlayGLEventListener();
    private MyExceptionHandler exceptionHandler = new MyExceptionHandler();


    public static GLDisplay createGLDisplay( String title, handlers.Renderer renderer ) {
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        boolean fullscreen = false;
        return new GLDisplay(title,DEFAULT_WIDTH,DEFAULT_HEIGHT,fullscreen,  renderer);
    }

    private GLDisplay(String title, int width, int height, boolean fullscreen, handlers.Renderer renderer) {
        GLProfile glprofile = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities( glprofile );
        glCanvas = new GLCanvas( );
       // glCanvas.setSize(width,height);

        glCanvas.setIgnoreRepaint(true);
        glCanvas.addGLEventListener(helpOverlayGLEventListener);

        glCanvas.addMouseWheelListener(new MouseWheelListener () {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation()==1 && scale > 0.6f) {
                    scale -= 0.1f;
                } else if (e.getWheelRotation()==-1 && scale <= 5f){
                    scale +=0.1f;
                }
            }
        });
        frame = new FiguresUI(glCanvas, renderer);

        this.fullscreen = fullscreen;
        this.width = width;
        this.height = height;

        animator = new FPSAnimator(glCanvas,60,true);
        animator.start();
        //
    }


    public void start() {
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          //  frame.setUndecorated( fullscreen );

            frame.addWindowListener( new MyWindowAdapter() );

            if ( fullscreen ) {
                usedDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                usedDevice.setFullScreenWindow( frame );
                usedDevice.setDisplayMode(
                        findDisplayMode(
                                usedDevice.getDisplayModes(),
                                width, height,
                                usedDevice.getDisplayMode().getBitDepth(),
                                usedDevice.getDisplayMode().getRefreshRate()
                        )
                );
            } else {
                frame.setSize( frame.getContentPane().getPreferredSize() );
                frame.setLocation(
                        ( screenSize.width - frame.getWidth() ) / 2,
                        ( screenSize.height - frame.getHeight() ) / 2
                );
                frame.setVisible( true );
            }

            glCanvas.requestFocus();

            animator.start();
        } catch ( Exception e ) {
            exceptionHandler.handleException( e );
        }
    }

    public void stop() {
        try {
            animator.stop();
            if ( fullscreen ) {
                usedDevice.setFullScreenWindow( null );
                usedDevice = null;
            }
            frame.dispose();
        } catch ( Exception e ) {
            exceptionHandler.handleException( e );
        } finally {
            System.exit( 0 );
        }
    }

    private DisplayMode findDisplayMode( DisplayMode[] displayModes, int requestedWidth, int requestedHeight, int requestedDepth, int requestedRefreshRate ) {
        // Try to find an exact match
        DisplayMode displayMode = findDisplayModeInternal( displayModes, requestedWidth, requestedHeight, requestedDepth, requestedRefreshRate );

        // Try again, ignoring the requested bit depth
        if ( displayMode == null )
            displayMode = findDisplayModeInternal( displayModes, requestedWidth, requestedHeight, DONT_CARE, DONT_CARE );

        // Try again, and again ignoring the requested bit depth and height
        if ( displayMode == null )
            displayMode = findDisplayModeInternal( displayModes, requestedWidth, DONT_CARE, DONT_CARE, DONT_CARE );

        // If all else fails try to get any display mode
        if ( displayMode == null )
            displayMode = findDisplayModeInternal( displayModes, DONT_CARE, DONT_CARE, DONT_CARE, DONT_CARE );

        return displayMode;
    }


    private DisplayMode findDisplayModeInternal( DisplayMode[] displayModes, int requestedWidth, int requestedHeight, int requestedDepth, int requestedRefreshRate ) {
        DisplayMode displayModeToUse = null;
        for ( int i = 0; i < displayModes.length; i++ ) {
            DisplayMode displayMode = displayModes[i];
            if ( ( requestedWidth == DONT_CARE || displayMode.getWidth() == requestedWidth ) &&
                    ( requestedHeight == DONT_CARE || displayMode.getHeight() == requestedHeight ) &&
                    ( requestedHeight == DONT_CARE || displayMode.getRefreshRate() == requestedRefreshRate ) &&
                    ( requestedDepth == DONT_CARE || displayMode.getBitDepth() == requestedDepth ) )
                displayModeToUse = displayMode;
        }

        return displayModeToUse;
    }



    public void addGLEventListener( GLEventListener glEventListener ) {
        this.helpOverlayGLEventListener.addGLEventListener( glEventListener );
    }

    public void removeGLEventListener( GLEventListener glEventListener ) {
        this.helpOverlayGLEventListener.removeGLEventListener( glEventListener );
    }

    public void addKeyListener( KeyListener l ) {
        glCanvas.addKeyListener( l );
    }

    public void addMouseListener( MouseListener l ) {
        glCanvas.addMouseListener( l );
    }

    public void addMouseMotionListener( MouseMotionListener l ) {
        glCanvas.addMouseMotionListener( l );
    }

    public void removeKeyListener( KeyListener l ) {
        glCanvas.removeKeyListener( l );
    }

    public void removeMouseListener( MouseListener l ) {
        glCanvas.removeMouseListener( l );
    }

    public void removeMouseMotionListener( MouseMotionListener l ) {
        glCanvas.removeMouseMotionListener( l );
    }

    public void registerKeyStrokeForHelp( KeyStroke keyStroke, String description ) {
        helpOverlayGLEventListener.registerKeyStroke( keyStroke, description );
    }

    public void registerMouseEventForHelp( int id, int modifiers, String description ) {
        helpOverlayGLEventListener.registerMouseEvent( id, modifiers, description );
    }

    public String getTitle() {
        return frame.getTitle();
    }

    public void setTitle( String title ) {
        frame.setTitle( title );
    }


    private class MyKeyAdapter extends KeyAdapter {
        public MyKeyAdapter() {
            registerKeyStrokeForHelp( KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0 ), "Show/hide help message" );
            registerKeyStrokeForHelp( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Quit demo" );
        }

        public void keyReleased( KeyEvent e ) {
            switch ( e.getKeyCode() ) {
                case KeyEvent.VK_ESCAPE:
                    stop();
                    break;
                case KeyEvent.VK_F1:
                    helpOverlayGLEventListener.toggleHelp();
                    break;
            }
        }
    }

    private class MyWindowAdapter extends WindowAdapter {
        public void windowClosing( WindowEvent e ) {
            stop();
        }
    }

    private class MyExceptionHandler implements ExceptionHandler {
        public void handleException( final Exception e ) {
            SwingUtilities.invokeLater( new Runnable() {
                public void run() {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter( stringWriter );
                    e.printStackTrace( printWriter );
                    JOptionPane.showMessageDialog( frame, stringWriter.toString(), "Exception occurred", JOptionPane.ERROR_MESSAGE );
                    stop();
                }
            } );
        }
    }

    private static class MyHelpOverlayGLEventListener implements GLEventListener {
        private java.util.List eventListeners = new ArrayList();
        private HelpOverlay helpOverlay = new HelpOverlay();
        private boolean showHelp = false;

        public void toggleHelp() {
            showHelp = !showHelp;
        }

        public void registerKeyStroke( KeyStroke keyStroke, String description ) {
            helpOverlay.registerKeyStroke( keyStroke, description );
        }

        public void registerMouseEvent( int id, int modifiers, String description ) {
            helpOverlay.registerMouseEvent( id, modifiers, description );
        }

        public void addGLEventListener( GLEventListener glEventListener ) {
            eventListeners.add( glEventListener );
        }

        public void removeGLEventListener( GLEventListener glEventListener ) {
            eventListeners.remove( glEventListener );
        }

        public void display( GLAutoDrawable glDrawable ) {
            for ( int i = 0; i < eventListeners.size(); i++ ) {
                ( (GLEventListener) eventListeners.get( i ) ).display( glDrawable );
            }
            if ( showHelp )
                helpOverlay.display( glDrawable );
        }

        public void displayChanged( GLAutoDrawable glDrawable, boolean b, boolean b1 ) {
            for ( int i = 0; i < eventListeners.size(); i++ ) {
                ( (GLEventListener) eventListeners.get( i ) ).display( glDrawable );
            }
        }

        public void init( GLAutoDrawable glDrawable ) {
            for ( int i = 0; i < eventListeners.size(); i++ ) {
                ( (GLEventListener) eventListeners.get( i ) ).init( glDrawable );
            }
        }

        @Override
        public void dispose(GLAutoDrawable glAutoDrawable) {

        }

        public void reshape( GLAutoDrawable glDrawable, int i0, int i1, int i2, int i3 ) {
            for ( int i = 0; i < eventListeners.size(); i++ ) {
                ( (GLEventListener) eventListeners.get( i ) ).reshape( glDrawable, i0, i1, i2, i3 );
            }
        }
    }

}
