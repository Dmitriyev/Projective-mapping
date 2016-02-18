package com.company;


import demos.common.GLDisplay;

/**
 * @author Pepijn Van Eeckhoudt
 */
public class Main {
    public static void main(String[] args) {
        GLDisplay neheGLDisplay = GLDisplay.createGLDisplay("Lesson 48: ArcBall Controller");
        Renderer renderer = new Renderer();
        InputHandler inputHandler = new InputHandler(renderer, neheGLDisplay);
        neheGLDisplay.addGLEventListener(renderer);
        neheGLDisplay.addMouseListener(inputHandler);
        neheGLDisplay.addMouseMotionListener(inputHandler);
        neheGLDisplay.start();
    }
}
