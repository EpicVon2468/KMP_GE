#include "kmp_ge.h"

#include <stdio.h>

#include "../glad/glad/gl.h"

void glShaderSource_K(const GLuint shader, const GLsizei count, const GLchar* string, const GLint* length) {
	glShaderSource(shader, count, &string, length);
}

GLint glGetUniformLocation_K(const GLuint program, const GLchar* name) {
	const int location = glGetUniformLocation(program, name);
	if (location == -1) {
		fprintf(stderr, "Couldn't get location of uniform named '%s'!", name);
		fflush(stderr);
	}
	return location;
}