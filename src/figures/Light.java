package figures;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.fixedfunc.GLLightingFunc;


/**
 * Created by fzxg on 19.02.2016.
 */
public class Light {
    private static float[] lightPos = {200f, 250f, 300f, 1f};        // light position
    private static float[] noAmbient = {0.5f, 0.5f, 0.5f, 1f};     // low ambient light
    private static float[] diffuse = {1f, 1f, 1f, 1f};        // full diffuse colour
    private static float[] spec =    {1f, 0.6f, 0f, 1f}; // low ambient light

    public static void setLight(GL2 gl, float x, float y, float z, float w) {
        lightPos[0] = x;
        lightPos[1] = y;
        lightPos[2] = z;
        lightPos[3] = w;
        gl.glEnable(GLLightingFunc.GL_LIGHTING);
        gl.glEnable(GLLightingFunc.GL_LIGHT0);

        // properties of the light
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR, spec, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION, lightPos, 0);
    }
}
