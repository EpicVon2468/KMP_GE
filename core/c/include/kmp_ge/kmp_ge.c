#include "kmp_ge.h"

#include "../glad/glad/gl.h"

void glShaderSource_K(const GLuint shader, const GLsizei count, const GLchar* string, const GLint* length) {
	glShaderSource(shader, count, &string, length);
}