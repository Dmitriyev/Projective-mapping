

uniform float Pa;
uniform float Pd;
uniform float Ps;
uniform float Shinnes;
uniform vec4 v4AmbientColor;
uniform vec4 v4DiffuseColor;
uniform vec4 v4SpecularColor;

varying vec3 v4Normal;
varying vec3 v4Eye;
varying vec3 v4Light;
varying vec3 v4ReflectVec;

uniform sampler2D Texture0;
varying vec4 v4TextureCoord;
uniform float Epsilon;

void main(void)
{
   vec3 v3NormNormal = normalize(v4Normal);
   vec3 v3NormEye = normalize(v4Eye);
   
   vec3 v3NormLight = normalize(v4Light);
   vec3 v3NormReflectVec = normalize(v4ReflectVec);
   
   vec2 texCoord = ( v4TextureCoord.xy / v4TextureCoord.w);
   
   vec4 v4CAmbientColor  = v4AmbientColor * Pa;
   vec4 v4CDefuseColor   = v4DiffuseColor * Pd * max(dot(v3NormLight, v3NormNormal), 0.0);
   vec4 v4CSpecularColor = v4SpecularColor * Ps * pow(max(dot(v3NormReflectVec, v3NormEye), 0.0), Shinnes);

   vec4 fragColor = (v4CAmbientColor + v4CDefuseColor + v4CSpecularColor);
   
   //if(v4TextureCoord.w > 0.0)
      fragColor += texture2D( Texture0, texCoord) * Epsilon;
      
   gl_FragColor = fragColor;
}
