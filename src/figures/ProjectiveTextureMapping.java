package figures;

import com.jogamp.opengl.GL2;

import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by fzxg on 20.02.2016.
 */
public class ProjectiveTextureMapping {
    private static float[] projectureCoords = { 10f, 10f, 10f};

    public static void makeWorldSpaceCoords() {

    }

    public static void drawTexture(GL2 gl) {
        float[] buf = {1f, 0f, 0f, 0f};
//        FloatBuffer buffer = new FloatBuffer();
//        buffer.put(buf);

        gl.glTexGeni(GL2.GL_S, GL2.GL_TEXTURE_GEN_MODE, GL2.GL_EYE_LINEAR);
//        gl.glTexGenfv(GL2.GL_S, GL2.GL_EYE_PLANE, FloatBuffer(buf));
        gl.glEnable(GL2.GL_TEXTURE_GEN_S);
    }
}
