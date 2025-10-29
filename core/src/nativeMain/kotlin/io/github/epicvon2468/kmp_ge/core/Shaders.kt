package io.github.epicvon2468.kmp_ge.core

const val VERTEX_SHADER: String =
	"#version 410 core\n" +
	"in vec3 vp;\n" +
	"void main() {\n" +
	"    gl_Position = vec4(vp, 1.0);\n" +
	"}\n"

const val FRAGMENT_SHADER: String =
	"#version 410 core\n" +
	"uniform float time;\n" +
	"out vec4 frag_colour;\n" +
	"vec3 colourA = vec3(0.149, 0.141, 0.912);\n" +
	"vec3 colourB = vec3(1.000, 0.833, 0.224);\n" +
	"void main() {\n" +
	"    vec3 colour = vec3(0.0);\n" +
	"    float pct = abs(sin(time));\n" +
	"    colour = mix(colourA, colourB, pct);\n" +
	"    frag_colour = vec4(colour, 1.0);\n" +
	"}\n"