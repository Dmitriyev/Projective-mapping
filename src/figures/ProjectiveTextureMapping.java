package figures;

import com.jogamp.opengl.GL2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;

/**
 * Created by fzxg on 20.02.2016.
 */
public class ProjectiveTextureMapping {
    private int vertexShaderProgram;
    private int fragmentShaderProgram;
    private int shaderprogram;
    public String[] vsrc;
    public String[] fsrc;

    //Shader uniform variables locations
    private int uPa, uPd, uPs;
    private int uEpsilon;
    private int uShinnes;
    private int uf3LightDir;
    private int uf3LightUp;
    private int ufvLightPos;
    private int uv4AmbientColor;
    private int uv4DiffuseColor;
    private int uv4SpecularColor;
    private int uvViewPosition;
    private int umatWorldInverse;
    private int uTexture0;

    //Uniform variables
    //Color parametrs
    private float Pa = 0.2f;
    private float Pd = 0.2f;
    private float Ps = 0.2f;
    private float Epsilon = 1f;
    private float Shinnes = 0.2f;

    private float[] v4AmbientColor = {0.2f, 0.2f, 0.2f, 1f};
    private float[] v4DiffuseColor = {0.2f, 0.2f, 0.2f, 1f};
    private float[] v4SpecularColor = {0.8f, 0.8f, 0.8f, 1f};

    //Projector position params
    //Use set<variable name>(float, float, float) to set this params
    private float[] fvLightPos = {0f, 0f, 2f, 1f};
    private float[] f3LightDir = {0f, 0f, 0f};
    private float[] f3LightUp = {0f, 1f, 1f};



    public int getShaderProgram() {return shaderprogram;}

    // this will attach the shaders
    public void init(GL2 gl)
    {
        try
        {
            attachShaders(gl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        getuniformLoacations(gl);
    }

    private void getuniformLoacations(GL2 gl) {
        uPa = gl.getGL2().glGetUniformLocation(shaderprogram, "Pa");
        uPd = gl.getGL2().glGetUniformLocation(shaderprogram, "Pd");
        uPs = gl.getGL2().glGetUniformLocation(shaderprogram, "Ps");
        uEpsilon = gl.getGL2().glGetUniformLocation(shaderprogram, "Epsilon");
        uShinnes = gl.getGL2().glGetUniformLocation(shaderprogram, "Shinnes");
        uf3LightDir = gl.getGL2().glGetUniformLocation(shaderprogram, "f3LightDir");
        uf3LightUp = gl.getGL2().glGetUniformLocation(shaderprogram, "f3LightUp");
        ufvLightPos = gl.getGL2().glGetUniformLocation(shaderprogram, "fvLightPos");
        uv4AmbientColor = gl.getGL2().glGetUniformLocation(shaderprogram, "v4AmbientColor");
        uv4DiffuseColor = gl.getGL2().glGetUniformLocation(shaderprogram, "v4DiffuseColor");
        uv4SpecularColor = gl.getGL2().glGetUniformLocation(shaderprogram, "v4SpecularColor");
        uvViewPosition = gl.getGL2().glGetUniformLocation(shaderprogram, "vViewPosition");
        umatWorldInverse = gl.getGL2().glGetUniformLocation(shaderprogram, "matWorldInverse");
        uTexture0 = gl.getGL2().glGetUniformLocation(shaderprogram, "Texture0");
    }
    // loads the shaders
    // in this example we assume that the shader is a file located in the applications JAR file.
    //
    public String[] loadShader(String name)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            //InputStream is = getClass().getResourceAsStream(name);
            BufferedReader br = new BufferedReader(new FileReader(name));
            String line;
            while ((line = br.readLine()) != null)
            {
                sb.append(line);
                sb.append('\n');
            }
            //is.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Shader is " + sb.toString());
        return new String[]
                { sb.toString() };
    }

    // This compiles and loads the shader to the video card.
    // if there is a problem with the source the program will exit at this point.
    //
    private void attachShaders(GL2 gl) throws Exception
    {
        vertexShaderProgram = gl.glCreateShader(GL2.GL_VERTEX_SHADER);
        fragmentShaderProgram = gl.glCreateShader(GL2.GL_FRAGMENT_SHADER);
        gl.glShaderSource(vertexShaderProgram, 1, vsrc, null, 0);
        gl.glCompileShader(vertexShaderProgram);
        gl.glShaderSource(fragmentShaderProgram, 1, fsrc, null, 0);
        gl.glCompileShader(fragmentShaderProgram);
        shaderprogram = gl.glCreateProgram();
        //
        gl.glAttachShader(shaderprogram, vertexShaderProgram);
        gl.glAttachShader(shaderprogram, fragmentShaderProgram);
        gl.glLinkProgram(shaderprogram);
        gl.glValidateProgram(shaderprogram);
        IntBuffer intBuffer = IntBuffer.allocate(1);
        gl.glGetProgramiv(shaderprogram, GL2.GL_LINK_STATUS, intBuffer);

        if (intBuffer.get(0) != 1)
        {
            gl.glGetProgramiv(shaderprogram, GL2.GL_INFO_LOG_LENGTH, intBuffer);
            int size = intBuffer.get(0);
            System.err.println("Program link error: ");
            if (size > 0)
            {
                ByteBuffer byteBuffer = ByteBuffer.allocate(size);
                gl.glGetProgramInfoLog(shaderprogram, size, intBuffer, byteBuffer);
                for (byte b : byteBuffer.array())
                {
                    System.err.print((char) b);
                }
            }
            else
            {
                System.out.println("Unknown");
            }
            System.exit(1);
        }
    }

    // this function is called when you want to activate the shader.
    // Once activated, it will be applied to anything that you draw from here on
    // until you call the dontUseShader(GL) function.
    public int useShader(GL2 gl)
    {
        gl.glUseProgram(shaderprogram);
        return shaderprogram;
    }

    // when you have finished drawing everything that you want using the shaders,
    // call this to stop further shader interactions.
    public void dontUseShader(GL2 gl)
    {
        gl.glUseProgram(0);
    }

    public void setParams(GL2 gl) {
        gl.getGL2().glUniform1f(uPa, Pa);
        gl.getGL2().glUniform1f(uPd, Pd);
        gl.getGL2().glUniform1f(uPs, Ps);
        gl.getGL2().glUniform1f(uEpsilon, Epsilon);
        gl.getGL2().glUniform1f(uShinnes, Shinnes);

        gl.getGL2().glUniform4fv(uv4AmbientColor, 1, v4AmbientColor, 0);
        gl.getGL2().glUniform4fv(uv4DiffuseColor, 1, v4DiffuseColor, 0);
        gl.getGL2().glUniform4fv(uv4SpecularColor, 1, v4SpecularColor, 0);

        gl.getGL2().glUniform3fv(ufvLightPos, 1, fvLightPos, 0);
        gl.getGL2().glUniform3fv(uf3LightDir, 1, f3LightDir, 0);
        gl.getGL2().glUniform3fv(uf3LightUp, 1, f3LightUp, 0);

        //gl.getGL2().glUniform4fv(uvViewPosition, 1, gl.glg, 0);
    }
}
