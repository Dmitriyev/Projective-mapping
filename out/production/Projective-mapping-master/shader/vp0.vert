
uniform vec4 fvLightPos;
uniform vec4 vViewPosition;
uniform mat4 mViewInv;
uniform mat4 mProj;
uniform vec4 vViewUp;
uniform vec3 f3LightDir;
uniform vec3 f3LightUp;

varying vec3 v4Normal;
varying vec3 v4Eye;
varying vec3 v4Light;
varying vec3 v4ReflectVec;

varying vec4 v4TextureCoord;

mat4 glLookAt( vec3 lightPos, vec3 lightDir, vec3 lightUp ){
   vec3 f = normalize(lightDir - lightPos);
   vec3 lightUpn = normalize(lightUp);
   vec3 s = cross(f, lightUpn);
   vec3 u = cross(s, f);
   
   mat4 M = mat4(  
            s.x,  s.y,  s.z, 0.0,
            u.x,  u.y,  u.z, 0.0,
           -f.x, -f.y, -f.z, 0.0,
            0.0,  0.0,  0.0, 0.1
         );
         
   mat4 translate = mat4(
                  1.0, 0.0, 0.0, -lightPos.x,
                  0.0, 1.0, 0.0, -lightPos.y,
                  0.0, 0.0, 1.0, -lightPos.z,
                  0.0, 0.0, 0.0, 1.0
                  );

   return M * translate;
}

mat4 glPerspective( float fovy, float aspect, float zNear, float zFar ){
   float f = 1.0 / tan(radians(fovy * 0.5));
   
   mat4 M = mat4(
                  f/aspect, 0.0, 0.0, 0.0,
                  0.0, f, 0.0, 0.0,
                  0.0, 0.0, (zFar+zNear)/(zNear - zFar), (2.0*zFar*zNear)/(zNear - zFar),
                  0.0, 0.0, -1.0, 0.0
                  );
   return M;
}

void main(void)
{   
   gl_Position = ftransform();
   
   vec4 v4Vertex = gl_ModelViewMatrix * gl_Vertex;
   
   v4Normal = gl_NormalMatrix * gl_Normal;
   v4Eye = vViewPosition.xyz - v4Vertex.xyz;      
   v4Light = (fvLightPos).xyz - v4Vertex.xyz;      
   v4ReflectVec = reflect(-v4Light, v4Normal);
   
   mat4 m4lightView = glLookAt(fvLightPos.xyz, f3LightDir, f3LightUp );
   mat4 m4lightProj = glPerspective( 45.0, 1.0, fvLightPos.z, 1.0 );
   
  mat4 S = mat4(
                  0.5, 0.0, 0.0, 0.0,
                  0.0, 0.5, 0.0, 0.0,
                  0.0, 0.0, 0.5, 0.0,
                  0.5, 0.5, 0.5, 1.0
                );
   mat4 M = mViewInv * gl_ModelViewMatrix;
   v4TextureCoord = S * m4lightProj * m4lightView * M * gl_Vertex;
}