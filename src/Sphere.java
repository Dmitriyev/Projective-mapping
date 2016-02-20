import com.jogamp.opengl.GL2;

/**
 * Created by fzxg on 19.02.2016.
 */
public class Sphere {
    public static void drawSphere(float r, int lats, int longs, GL2 gl) {
        int i, j;
        for(i = 0; i <= lats; i++) {
            float lat0 = (float) Math.PI * (-0.5f + (i - 1.0f) / lats);
            float z0  = (float) Math.sin(lat0);
            float zr0 = (float) Math.cos(lat0);

            float lat1 = (float) Math.PI * (-0.5f + (float) i / lats);
            float z1 = (float) Math.sin(lat1);
            float zr1 = (float) Math.cos(lat1);

            gl.glColor3f(0.7f, 0.7f, 0.7f);
            gl.glBegin(gl.GL_QUAD_STRIP);

            for(j = 0; j <= longs; j++) {
                float lng = 2.0f * (float) Math.PI * (float) (j - 1) / longs;
                float x = (float) Math.cos(lng);
                float y = (float) Math.sin(lng);

                gl.glNormal3f(x * zr0, y * zr0, z0);
                gl.glVertex3f(x * zr0, y * zr0, z0);
                gl.glNormal3f(x * zr1, y * zr1, z1);
                gl.glVertex3f(x * zr1, y * zr1, z1);
            }
            gl.glEnd();
        }
    }
}
