import com.jogamp.opengl.GL2;

/**
 * Created by fzxg on 19.02.2016.
 */
public class Pyramid {
    public static void drawPyramid(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glColor3f(0.7f, 0.7f, 0.7f);
        gl.glNormal3f(0f, 1f, 0f);
        gl.glVertex3f(1.0f, 0.5f, -1.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f(-1.0f, 0.5f, -1.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f(-1.0f, 0.5f, 1.0f); // Bottom Left Of The Quad (Top)
        gl.glVertex3f(1.0f, 0.5f, 1.0f); // Bottom Right Of The Quad (Top)

        gl.glNormal3f(0f, -1f, 0f);
        gl.glVertex3f(1.0f, -0.5f, 1.0f); // Top Right Of The Quad
        gl.glVertex3f(-1.0f, -0.5f, 1.0f); // Top Left Of The Quad
        gl.glVertex3f(-1.0f, -0.5f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -0.5f, -1.0f); // Bottom Right Of The Quad

        gl.glNormal3f(0f, 0f, 1f);
        gl.glVertex3f(1.0f, 0.5f, 1.0f); // Top Right Of The Quad (Front)
        gl.glVertex3f(-1.0f, 0.5f, 1.0f); // Top Left Of The Quad (Front)
        gl.glVertex3f(-1.0f, -0.5f, 1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -0.5f, 1.0f); // Bottom Right Of The Quad

        gl.glNormal3f(0f, 0f, -1f);
        gl.glVertex3f(1.0f, -0.5f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(-1.0f, -0.5f, -1.0f); // Bottom Right Of The Quad
        gl.glVertex3f(-1.0f, 0.5f, -1.0f); // Top Right Of The Quad (Back)
        gl.glVertex3f(1.0f, 0.5f, -1.0f); // Top Left Of The Quad (Back)

        gl.glNormal3f(-1f, 0f, 0f);
        gl.glVertex3f(-1.0f, 0.5f, 1.0f); // Top Right Of The Quad (Left)
        gl.glVertex3f(-1.0f, 0.5f, -1.0f); // Top Left Of The Quad (Left)
        gl.glVertex3f(-1.0f, -0.5f, -1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(-1.0f, -0.5f, 1.0f); // Bottom Right Of The Quad

        gl.glNormal3f(1f, 0f, 0f);
        gl.glVertex3f(1.0f, 0.5f, -1.0f); // Top Right Of The Quad (Right)
        gl.glVertex3f(1.0f, 0.5f, 1.0f); // Top Left Of The Quad
        gl.glVertex3f(1.0f, -0.5f, 1.0f); // Bottom Left Of The Quad
        gl.glVertex3f(1.0f, -0.5f, -1.0f); // Bottom Right Of The Quad
    }

}
