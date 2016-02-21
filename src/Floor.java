import com.jogamp.opengl.GL2;

/**
 * Created by fzxg on 20.02.2016.
 */
public class Floor {
    public static void drawFloor(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glColor3f(0.9f, 0.9f, 0.9f);
        gl.glNormal3f(0f, 1f, 0f);
        gl.glVertex3f(2.0f, -2.5f, -7.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f(-7.0f, -2.5f, -2.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f(-2.0f, -2.5f, 7.0f); // Bottom Left Of The Quad (Top)
        gl.glVertex3f(7.0f, -2.5f, 2.0f); // Bottom Right Of The Quad (Top)
    }
}
