#ifndef KMP_GE_KMP_GE_H
#define KMP_GE_KMP_GE_H

#include <stdbool.h>

void glShaderSource_K(unsigned int shader, int count, const char* string, const int* length);

int glGetUniformLocation_K(unsigned int program, const char* name);

bool loadGL();

void cMain();

#endif // KMP_GE_KMP_GE_H