package handlers;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import display.GLDisplay;
import figures.*;
import gui.FiguresUI;

import java.awt.*;
import java.io.File;

/**
 * Created by Admin on 22.02.2016.
 */
public class Renderer implements GLEventListener {
    // User Defined Variables
    private GLUquadric quadratic;                                            // Used For Our Quadric
    private GLU glu = new GLU();

    public static FIGURE figure = FIGURE.CUBE;
    private float radius = 1.0f;
    public static int longs = 100;
    public static int lats = 100;
    public static File configFile;

    private Matrix4f LastRot = new Matrix4f();
    private Matrix4f ThisRot = new Matrix4f();
    private final Object matrixLock = new Object();
    private float[] matrix = new float[16];

    public static float xProjectorCoord = 5;
    public static float yProjectorCoord = 5;
    public static float zProjectorCoord = 5;

    private ProjectiveTextureMapping shader = new ProjectiveTextureMapping();
    //private float a[] = {0.5f, 0.05f, 0.05f, 1f};
    public static File projectorFile;


    private ArcBall arcBall = new ArcBall(640.0f, 480.0f);

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glViewport(0, 0, width, height);                // Reset The Current Viewport
        gl.glMatrixMode(GL2.GL_PROJECTION);                                        // Select The Projection Matrix
        gl.glLoadIdentity();                                                    // Reset The Projection Matrix
        glu.gluPerspective(45.0f, (float) (width) / (float) (height),            // Calculate The Aspect Ratio Of The Window
                1.0f, 100.0f);
        gl.glMatrixMode(GL2.GL_MODELVIEW);                                        // Select The Modelview Matrix
        gl.glLoadIdentity();                                                    // Reset The Modelview Matrix

        arcBall.setBounds((float) width, (float) height);                 //*NEW* Update mouse bounds for arcball
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        init(drawable);
    }

    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Start Of User Initialization
        LastRot.setIdentity();                                // Reset Rotation
        ThisRot.setIdentity();                                // Reset Rotation
        ThisRot.get(matrix);

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);                            // Black Background
        gl.glClearDepth(1.0f);                                            // Depth Buffer Setup
        gl.glDepthFunc(GL2.GL_LEQUAL);                                        // The Type Of Depth Testing (Less Or Equal)
        gl.glEnable(GL2.GL_DEPTH_TEST);                                        // Enable Depth Testing
        gl.glShadeModel(GL2.GL_FLAT);                                            // Select Flat Shading (Nice Definition Of Objects)
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);                // Set Perspective Calculations To Most Accurate

        quadratic = glu.gluNewQuadric();                                        // Create A Pointer To The Quadric Object
        glu.gluQuadricNormals(quadratic, GLU.GLU_SMOOTH);                        // Create Smooth Normals
        glu.gluQuadricTexture(quadratic, true);                            // Create Texture Coords

        Light.setLight(gl,10,10,10,0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);                                    // Enable Color Material
        //    Floor.drawFloor(gl);


        shader.fsrc = shader.loadShader("src\\shader\\f.txt"); // fragment GLSL Code
        shader.vsrc = shader.loadShader("src\\shader\\v.txt"); // vertex GLSL Code
        shader.init(gl);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    void reset() {
        synchronized(matrixLock) {
            LastRot.setIdentity();                                // Reset Rotation
            ThisRot.setIdentity();                                // Reset Rotation
        }
    }

    void startDrag( Point MousePt ) {
        synchronized(matrixLock) {
            LastRot.set( ThisRot );                                        // Set Last Static Rotation To Last Dynamic One
        }
        arcBall.click( MousePt );                                 // Update Start Vector And Prepare For Dragging
    }

    void drag( Point MousePt )                                    // Perform Motion Updates Here
    {
        Quat4f ThisQuat = new Quat4f();

        arcBall.drag( MousePt, ThisQuat);                         // Update End Vector And Get Rotation As Quaternion
        synchronized(matrixLock) {
            ThisRot.setRotation(ThisQuat);     // Convert Quaternion Into Matrix3fT
            ThisRot.mul( ThisRot, LastRot);                // Accumulate Last Rotation Into This One
        }
    }

    void torus(GL2 gl, float MinorRadius, float MajorRadius)                    // Draw A Torus With Normals
    {
        int i, j;
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);                                    // Start A Triangle Strip
        for (i = 0; i < 20; i++)                                        // Stacks
        {
            for (j = -1; j < 20; j++)                                    // Slices
            {
                float wrapFrac = (j % 20) / (float) 20;
                double phi = Math.PI * 2.0 * wrapFrac;
                float sinphi = (float) (Math.sin(phi));
                float cosphi = (float) (Math.cos(phi));

                float r = MajorRadius + MinorRadius * cosphi;

                gl.glNormal3d(
                        (Math.sin(Math.PI * 2.0 * (i % 20 + wrapFrac) / (float) 20)) * cosphi,
                        sinphi,
                        (Math.cos(Math.PI * 2.0 * (i % 20 + wrapFrac) / (float) 20)) * cosphi);
                gl.glVertex3d(
                        (Math.sin(Math.PI * 2.0 * (i % 20 + wrapFrac) / (float) 20)) * r,
                        MinorRadius * sinphi,
                        (Math.cos(Math.PI * 2.0 * (i % 20 + wrapFrac) / (float) 20)) * r);

                gl.glNormal3d(
                        (Math.sin(Math.PI * 2.0 * (i + 1 % 20 + wrapFrac) / (float) 20)) * cosphi,
                        sinphi,
                        (Math.cos(Math.PI * 2.0 * (i + 1 % 20 + wrapFrac) / (float) 20)) * cosphi);
                gl.glVertex3d(
                        (Math.sin(Math.PI * 2.0 * (i + 1 % 20 + wrapFrac) / (float) 20)) * r,
                        MinorRadius * sinphi,
                        (Math.cos(Math.PI * 2.0 * (i + 1 % 20 + wrapFrac) / (float) 20)) * r);
            }
        }
        gl.glEnd();                                                        // Done Torus
    }
    private void setCamera(GL2 gl, GLU glu, float distance) {
        // Change to projection matrix.
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Perspective.
        float widthHeightRatio = 1.5f;
        //Два метода задания начальной точки

        glu.gluPerspective(45, widthHeightRatio, 1, 1000); // через углы
        glu.gluLookAt(10, 10, distance, 0, 0, 0, 0, 1, 0); // через точки
        // Change back to model view matrix.
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    public void display(GLAutoDrawable drawable) {
        synchronized(matrixLock) {
            ThisRot.get(matrix);
        }

        GL2 gl = drawable.getGL().getGL2();
        setCamera(gl,glu, 10);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);                // Clear Screen And Depth Buffer

        // Rotate The Cube On X, Y & Z
        gl.glLoadIdentity();                                                // Reset The Current Modelview Matrix

    //    shader.useShader(gl);
     //   int waveWidthLoc = gl.getGL2().glGetUniformLocation(shader.getShaderProgram(), "a");
//       gl.getGL2().glUniform4fv(waveWidthLoc, 1, a, 0);

        gl.glTranslatef(0f, 0f, -6.0f);
        gl.glScalef(GLDisplay.scale, GLDisplay.scale, GLDisplay.scale);
        gl.glPushMatrix();                                                    // NEW: Prepare Dynamic Transform
        gl.glMultMatrixf(matrix, 0);                                        // NEW: Apply Dynamic Transform
        Floor.drawFloor(gl);
        gl.glEnd();
        gl.glColor3f(0.45f, 0.45f, 0.45f);
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
        gl.glPopMatrix();                                                    // NEW: Unapply Dynamic Transform
        
        gl.glLoadIdentity();                                                // Reset The Current Modelview Matrix

        gl.glPushMatrix();                                                    // NEW: Prepare Dynamic Transform
        gl.glMultMatrixf(matrix, 0);                                        // NEW: Apply Dynamic Transform
        gl.glColor3f(1.0f, 0.75f, 0.75f);
        gl.glPopMatrix();                                                    // NEW: Unapply Dynamic Transform
        gl.glEnd();
//        shader.dontUseShader(gl);
        gl.glFlush();                                                        // Flush The GL Rendering Pipeline
    }
}