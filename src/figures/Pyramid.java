package figures;

import com.jogamp.opengl.GL2;

/**
 * Created by fzxg on 19.02.2016.
 */
public class Pyramid {
    public static void drawPyramid(GL2 gl) {
        gl.glBegin(GL2.GL_TRIANGLES);
    //    gl.glColor3f(0.52f,0.44f,1.0f);// Сделали боковую сторону фиолетовой

        gl.glNormal3f(0f, 1f, 0f);
        gl.glVertex3f( 1.0f, 0.0f,-1.0f);
        gl.glVertex3f(1.0f, 0.0f,1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL2.GL_TRIANGLES);
     //   gl.glColor3f(1.0f,0.84f,0.0f);  // Сделали боковую сторону желтой

        gl.glVertex3f( 1.0f,0.0f, 1.0f);
        gl.glVertex3f(-1.0f,0.0f, 1.0f);
        gl.glVertex3f(0.0f,1.0f,0.0f);
        gl.glEnd();

        gl.glBegin(GL2.GL_TRIANGLES);
      //  gl.glColor3f(0.94f,0.5f,0.5f);// Сделали сторону  розовой

        gl.glVertex3f(-1.0f,0.0f,1.0f);
        gl.glVertex3f(-1.0f, 0.0f,-1.0f);
        gl.glVertex3f(0.0f,1.0f,0.0f);
        gl.glEnd();

        gl.glBegin(GL2.GL_TRIANGLES);
      //  gl.glColor3f(0.0f,1.0f,0.0f);  // Сделали сторону  светло зеленой

        gl.glVertex3f(-1.0f,0.0f,-1.0f);
        gl.glVertex3f(1.0f,0.0f,-1.0f);
        gl.glVertex3f(0.0f, 1.0f,0.0f);
        gl.glEnd();

        gl.glBegin(GL2.GL_QUADS);// основание пирамиды
      //  gl.glColor3f(1.0f,0.51f,0.28f); // сделали основание рыжим

        gl.glVertex3f( 1.0f,0.0f, 1.0f);
        gl.glVertex3f(-1.0f,0.0f, 1.0f);
        gl.glVertex3f(-1.0f,0.0f,-1.0f);
        gl.glVertex3f( 1.0f,0.0f,-1.0f);
        gl.glEnd();
    }

}
