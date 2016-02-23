package handlers;

import display.GLDisplay;

/**
 * Created by Admin on 22.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        
        Renderer renderer = new Renderer();
        GLDisplay neheGLDisplay = GLDisplay.createGLDisplay("TestTask", renderer);
        InputHandler inputHandler = new InputHandler(renderer, neheGLDisplay);
        neheGLDisplay.addGLEventListener( renderer);
        neheGLDisplay.addMouseListener(inputHandler);
        neheGLDisplay.addMouseMotionListener(inputHandler);
        neheGLDisplay.start();
    }
}
