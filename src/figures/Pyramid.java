package figures;

import com.jogamp.opengl.GL2;

/**
 * Created by fzxg on 19.02.2016.
 */
public class Pyramid {
    public static void drawPyramid(GL2 gl) {

       /* gl.glLoadIdentity();
        //glu.gluLookAt(0.0, 0.0, 3.0, 0.0, 0.0, 0.0,  0.0,1.0, 0.0);
        gl.glTranslatef(0.0f,-1.0f,-8.0f);
        gl.glRotatef(-60.0f,0,1,0);
        gl.glRotatef(-70.0f,1,0,0);*/

        float dimf = 0.5f;
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1,0,0);
        gl.glVertex3d(dimf,0, +dimf);          // Top Of Triangle (Front)
        gl.glVertex3d(0,4*dimf,0);          // Left Of Triangle (Front)
        gl.glVertex3d(-dimf,0,+dimf);          // Right Of Triangle (Front)

        gl.glColor3f(0,1,0);
        gl.glVertex3d(-dimf,0,dimf);          // Top Of Triangle (Right)
        gl.glVertex3d(0,+4*dimf,0);          // Left Of Triangle (Right)
        gl.glVertex3d(-dimf,0,-dimf);         // Right Of Triangle (Right)

        gl.glColor3f(0,0,1);
        gl.glVertex3d(-dimf,0,-dimf);          // Top Of Triangle (Back)
        gl.glVertex3d(0,+4*dimf, 0);         // Left Of Triangle (Back)
        gl.glVertex3d(dimf,0,-dimf);         // Right Of Triangle (Back)

        gl.glColor3f(1,1,0);
        gl.glVertex3d(dimf, 0,-dimf);          // Top Of Triangle (Left)
        gl.glVertex3d(0,+4*dimf,0);          // Left Of Triangle (Left)
        gl.glVertex3d(dimf,0, +dimf);          // Right Of Triangle (Left)

        gl.glColor3f(1,1,1);
        gl.glVertex3d(-dimf, 0,dimf);          // Top Of Triangle (Left)
        gl.glVertex3d(-dimf,0,-dimf);          // Left Of Triangle (Left)
        gl.glVertex3d(dimf,0, +dimf);          // Right Of Triangle (Left)
        gl.glVertex3d(dimf,0, +dimf);          // Right Of Triangle (Left)
        gl.glVertex3d(-dimf,0, -dimf);          // Right Of Triangle (Left)
        gl.glVertex3d(dimf,0, -dimf);          // Right Of Triangle (Left)
        gl.glEnd();
      /*  gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

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
        gl.glVertex3f(1.0f, -0.5f, -1.0f); // Bottom Right Of The Quad*/
    }

}
