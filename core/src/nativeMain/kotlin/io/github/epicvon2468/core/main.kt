package io.github.epicvon2468.core

import glfw.glfwSetErrorCallback

import io.github.epicvon2468.core.interop.gl.glGetString
import io.github.epicvon2468.core.interop.gl.GL_SHADING_LANGUAGE_VERSION
import io.github.epicvon2468.core.interop.glfw.context.glfwSwapInterval
import io.github.epicvon2468.core.interop.glfw.context.glfwMakeContextCurrent
import io.github.epicvon2468.core.interop.glfw.GLFWWindowC
import io.github.epicvon2468.core.interop.glfw.glfwCreateWindow
import io.github.epicvon2468.core.interop.glfw.glfwPollEvents
import io.github.epicvon2468.core.interop.glfw.glfwSwapBuffers
import io.github.epicvon2468.core.interop.glfw.glfwWindowShouldClose
import io.github.epicvon2468.core.interop.glfw.glfwDestroyWindow
import io.github.epicvon2468.core.interop.glfw.init.glfwGetVersionString
import io.github.epicvon2468.core.interop.glfw.init.glfwInit
import io.github.epicvon2468.core.interop.glfw.init.glfwTerminate

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
// https://dri.freedesktop.org/wiki/libGL/
// https://www.opengl.org/sdk/
// https://mesa3d.org/ (https://gitlab.freedesktop.org/mesa/mesa)
@OptIn(ExperimentalForeignApi::class)
fun main() {
	println("GLFW version: ${glfwGetVersionString()}")

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