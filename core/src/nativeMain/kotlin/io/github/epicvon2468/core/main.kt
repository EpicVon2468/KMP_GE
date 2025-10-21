package io.github.epicvon2468.core

import glfw.glfwSetErrorCallback

import io.github.epicvon2468.core.interop.GLFWWindowC
import io.github.epicvon2468.core.interop.glfwInit
import io.github.epicvon2468.core.interop.glfwTerminate
import io.github.epicvon2468.core.interop.glfwSwapInterval
import io.github.epicvon2468.core.interop.glfwCreateWindow
import io.github.epicvon2468.core.interop.glGetString
import io.github.epicvon2468.core.interop.glfwMakeContextCurrent
import io.github.epicvon2468.core.interop.GL_SHADING_LANGUAGE_VERSION
import io.github.epicvon2468.core.interop.glfwPollEvents
import io.github.epicvon2468.core.interop.glfwSwapBuffers
import io.github.epicvon2468.core.interop.glfwWindowShouldClose
import io.github.epicvon2468.core.interop.glfwDestroyWindow

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

	// Wouldn't normally be able to access GLFWWindowC, but I'll use this cheat for now since I haven't implemented all the functions yet.
	val window: GLFWWindowC? = glfwCreateWindow(1920, 1080, "KMP_GE") as GLFWWindowC?
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

	while (!glfwWindowShouldClose(window)) {
		glfwSwapBuffers(window)
		glfwPollEvents()
	}

	glfwDestroyWindow(window)
	glfwTerminate()

	exit(EXIT_SUCCESS)
}