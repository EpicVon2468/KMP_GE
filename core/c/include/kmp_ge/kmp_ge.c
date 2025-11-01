#include "kmp_ge.h"

#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>

#include "../glad/glad/gl.h"
#include "../glfw3.h"

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

bool loadGL() {
	return gladLoadGL(glfwGetProcAddress);
}

// https://stackoverflow.com/questions/20639632/how-to-wrap-printf-into-a-function-or-macro
void logE(const char* format, ...) {
	va_list args;
	va_start(args, format);
	vfprintf(stderr, format, args);
	va_end(args);
	fflush(stderr);
}

void errorCallback(int errorCode, const char* description) {
	logE("GLFW error occurred! Message: '%s'!\n", description);
}

void framebufferSizeCallback(GLFWwindow* window, const int width, const int height) {
	glViewport(0, 0, width, height);
}

void debugMessageCallback(const GLenum source, const GLenum type, const GLuint id, const GLenum severity, const GLsizei length, const char* message, const void* userParam) {
	fprintf(stderr, "DebugProc {\n\tsource = %u,\n\ttype = %u,\n\tid = %u,\n\tseverity = %u,\n\tlength = %d,\n\tmessage = '%s',\n\tuserParam = %p\n}\n", source, type, id, severity, length, message, userParam);
}

typedef void (* ObjChecker)(GLuint obj, GLenum name, GLint* params);

void checkCompile(const ObjChecker checker, const int status, const GLuint obj, const char* name) {
	int cStatus;
	checker(obj, status, &cStatus);
	printf("Obj '%s' (%d) status: %d.\n", name, obj, cStatus);
}

const char* vertexShaderString =
	"#version 410 core\n"
	"in vec3 vp;\n"
	"void main() {\n"
	"	gl_Position = vec4(vp, 1.0);\n"
	"}";

const char* fragmentShaderString =
	"#version 410 core\n"
	"uniform float time;\n"
	"out vec4 frag_colour;\n"
	"vec3 colourA = vec3(0.149, 0.141, 0.912);\n"
	"vec3 colourB = vec3(1.000, 0.833, 0.224);\n"
	"void main() {\n"
	"	vec3 colour = vec3(0.0);\n"
	"	float pct = abs(sin(time));\n"
	"	colour = mix(colourA, colourB, pct);\n"
	"	frag_colour = vec4(colour, 1.0);\n"
	"}";

void cMain() {
	glfwSetErrorCallback(errorCallback);

	if (!glfwInit()) {
		logE("GLFW failed to initialise!\n");
		exit(EXIT_FAILURE);
	}

	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
	GLFWwindow* window = glfwCreateWindow(640, 480, "KMP_GE (C)", NULL, NULL);
	if (!window) {
		logE("GLFWwindow failed to create!\n");
		glfwTerminate();
		exit(EXIT_FAILURE);
	}

	glfwMakeContextCurrent(window);
	if (!loadGL()) {
		logE("Glad failed to load GL!\n");
		glfwTerminate();
		exit(EXIT_FAILURE);
	}
	glfwSetFramebufferSizeCallback(window, framebufferSizeCallback);
	glfwSwapInterval(1);

	glEnable(GL_DEBUG_OUTPUT);
	glEnable(GL_DEBUG_OUTPUT_SYNCHRONOUS);

	glDebugMessageCallback(debugMessageCallback, NULL);

	const float vertices[] = {
		0.0f, 0.5f, 0.0f,
		0.5f, -0.5f, 0.0f,
		-0.5f, -0.5f, 0.0f
	};

	GLuint vertexBuffer = 0;
	glGenBuffers(1, &vertexBuffer);
	glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
	glBufferData(GL_ARRAY_BUFFER, 9 * sizeof(float), vertices, GL_STATIC_DRAW);

	GLuint vertexArray = 0;
	glGenVertexArrays(1, &vertexArray);
	glBindVertexArray(vertexArray);
	glEnableVertexAttribArray(0);
	glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer);
	glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, NULL);

	const GLuint vertexShader = glCreateShader(GL_VERTEX_SHADER);
	glShaderSource(vertexShader, 1, &vertexShaderString, NULL);
	glCompileShader(vertexShader);
	checkCompile(glGetShaderiv, GL_COMPILE_STATUS, vertexShader, "Vertex Shader");

	const GLuint fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
	glShaderSource(fragmentShader, 1, &fragmentShaderString, NULL);
	glCompileShader(fragmentShader);
	checkCompile(glGetShaderiv, GL_COMPILE_STATUS, fragmentShader, "Fragment Shader");

	const GLuint program = glCreateProgram();
	glAttachShader(program, fragmentShader);
	glAttachShader(program, vertexShader);
	glLinkProgram(program);
	checkCompile(glGetProgramiv, GL_LINK_STATUS, program, "Shader Program");

	const GLint uTimeLocation = glGetUniformLocation(program, "time");

	int width, height;
	glfwGetFramebufferSize(window, &width, &height);
	glViewport(0, 0, width, height);

	while (!glfwWindowShouldClose(window)) {
		glClear(GL_COLOR_BUFFER_BIT);

		glUseProgram(program);
		glUniform1f(uTimeLocation, (float) glfwGetTime());
		glBindVertexArray(vertexArray);

		glDrawArrays(GL_TRIANGLES, 0, 3);

		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	glfwDestroyWindow(window);
	glfwTerminate();

	printf("End of cMain, now to Kotlin main!\n");
}