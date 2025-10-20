package io.github.epicvon2468.core

import cnames.structs.GLFWwindow

import glfw.GLFW_FALSE
import glfw.GL_SHADING_LANGUAGE_VERSION
import glfw.glfwCreateWindow
import glfw.glfwDestroyWindow
import glfw.glfwMakeContextCurrent
import glfw.glfwPollEvents
import glfw.glfwSetErrorCallback
import glfw.glfwSwapBuffers
import glfw.glfwWindowShouldClose

import io.github.epicvon2468.core.interop.glfwInit
import io.github.epicvon2468.core.interop.glfwTerminate
import io.github.epicvon2468.core.interop.glfwSwapInterval
import io.github.epicvon2468.core.interop.glGetString

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

import platform.posix.EXIT_FAILURE
import platform.posix.EXIT_SUCCESS
import platform.posix.exit

// Just some tests for GLFW interop.
// https://www.glfw.org/docs/latest/quick_guide.html
@OptIn(ExperimentalForeignApi::class)
fun main() {
	if (!glfwInit()) {
		println("ERROR - Failed to initialise GLFW!")
		exit(EXIT_FAILURE)
	}

	glfwSetErrorCallback(staticCFunction { error: Int, cDescription: CPointer<ByteVar>? ->
		val description: String? = cDescription?.toKString()
		println("ERROR - GLFW - Code '$error', message: '$description'")
	})

	val window: CPointer<GLFWwindow>? = glfwCreateWindow(1920, 1080, "KMP_GE", null, null)
	window ?: {
		glfwTerminate()
		println("ERROR - GLFWwindow failed to create!")
		exit(EXIT_FAILURE)
	}
	// Static analysis can't seem to understand that window should be non-null by this point (see above), so re-enforce:
	window!!

	glfwMakeContextCurrent(window)
	// V-Sync.
	glfwSwapInterval(1)

	println("OpenGL shader language version: ${glGetString(GL_SHADING_LANGUAGE_VERSION)}")

	while (glfwWindowShouldClose(window) == GLFW_FALSE) {
		glfwSwapBuffers(window)
		glfwPollEvents()
	}

	glfwDestroyWindow(window)
	glfwTerminate()

	exit(EXIT_SUCCESS)
}