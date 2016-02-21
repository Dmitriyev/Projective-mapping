package figure;

import com.company.GLDisplay;


/**
 * @author Pepijn Van Eeckhoudt
 */
public class Lesson48 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("path"));
        GLDisplay neheGLDisplay = GLDisplay.createGLDisplay("Lesson 48: ArcBall Controller");
        Renderer renderer = new Renderer();
        InputHandler inputHandler = new InputHandler(renderer, neheGLDisplay);
        neheGLDisplay.addGLEventListener( renderer);
        neheGLDisplay.addMouseListener(inputHandler);
        neheGLDisplay.addMouseMotionListener(inputHandler);
        neheGLDisplay.start();
    }
}
