package figures;

import java.awt.DisplayMode;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import gui.FiguresUI;
import gui.WindowGUI;

public class Main implements GLEventListener {

    
    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private float rquad = 0.0f;
    public static FIGURE figure = FIGURE.SPHERE;
    private float radius = 1.0f;
    public static int longs = 100;
    public static int lats = 100;

    public FIGURE getFigure() {
        return figure;
    }
    public void setFigure(FIGURE newFigure) {
        figure = newFigure;
    }
    @Override
    public void display( GLAutoDrawable drawable ) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0f, 0f, -5.0f);
        // Rotate The Cube On X, Y & Z
        Floor.drawFloor(gl);
        gl.glEnd(); // Done Drawing The Quad
        gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);

        switch(figure) {
            case CUBE:
                Cube.drawCube(gl);
                break;

            case PYRAMID:
                Pyramid.drawPyramid(gl);
                break;

            case SPHERE:
                Sphere.drawSphere(radius, longs, lats, gl);
                break;
        }
        gl.glEnd(); // Done Drawing The Quad
        gl.glFlush();

        rquad -= 0.15f;
    }

    @Override
    public void dispose( GLAutoDrawable drawable ) {
        // TODO Auto-generated method stub
    }

    @Override
    public void init( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);

//        gl.glEnable(GL2.GL_POLYGON_SMOOTH);
//        gl.glEnable(GL2.GL_BLEND);
//        gl.glShadeModel(GL2.GL_SMOOTH);

        Light.setLight(gl);
    }

    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {

        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        //if( height lt; = 0 )
        height = 700;

        final float h = ( float ) width / ( float ) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, h, 1.0, 100.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public static void main( String[] args ) {

        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Main cube = new Main();

        glcanvas.addGLEventListener( cube );
        glcanvas.setSize( 400, 400 );
/*
        final JFrame frame = new JFrame ( " Multicolored cube" );
        frame.getContentPane().add( glcanvas );
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );*/
        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
    //    WindowGUI gui = new WindowGUI(glcanvas);
    FiguresUI tmp = new FiguresUI(glcanvas);
    //tmp.setVisible(true);
   // tmp.getContentPane().add(glcanvas);
        animator.start();
    }

}