@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core

import gl.GLADapiproc
import gl.gladLoadGL
import glfw.glfwGetProcAddress

import io.github.epicvon2468.core.interop.exitProcess
import io.github.epicvon2468.core.interop.gl.glGetString
import io.github.epicvon2468.core.interop.gl.GL_SHADING_LANGUAGE_VERSION
import io.github.epicvon2468.core.interop.glfw.context.glfwSwapInterval
import io.github.epicvon2468.core.interop.glfw.context.glfwMakeContextCurrent
import io.github.epicvon2468.core.interop.glfw.window.GLFWWindowC
import io.github.epicvon2468.core.interop.glfw.window.glfwCreateWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwDestroyWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwWindowShouldClose
import io.github.epicvon2468.core.interop.glfw.window.glfwPollEvents
import io.github.epicvon2468.core.interop.glfw.window.glfwSwapBuffers
import io.github.epicvon2468.core.interop.glfw.init.glfwGetVersionString
import io.github.epicvon2468.core.interop.glfw.init.glfwInit
import io.github.epicvon2468.core.interop.glfw.init.glfwSetErrorCallback
import io.github.epicvon2468.core.interop.glfw.init.glfwTerminate

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

import platform.posix.EXIT_FAILURE
import platform.posix.EXIT_SUCCESS

const val VERTEX_SHADER: String = "#version 330\nuniform mat4 MVP;\nin vec3 vCol;\nin vec2 vPos;\nout vec3 color;\nvoid main() {\ngl_Position = MVP * vec4(vPos, 0.0, 1.0);\ncolor = vCol;\n}"

const val FRAGMENT_SHADER: String = "#version 330\nin vec3 color;\nout vec4 fragment;\nvoid main() {\nfragment = vec4(color, 1.0);\n}"

fun ktGlfwGetProcAddress(ptr: CPointer<ByteVar>?): GLADapiproc? = glfwGetProcAddress(ptr?.toKString())

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
		exitProcess(EXIT_FAILURE)
	}

	// To test this, window hint GLFW_CONTEXT_VERSION_MAJOR and GLFW_CONTEXT_VERSION_MINOR to something absurd like 99.
	glfwSetErrorCallback { errorCode: Int, description: String? ->
		println("ERROR - GLFWErrorFun: (errorCode: '$errorCode', message: '$description')")
	}

	// Wouldn't normally be able to access GLFWWindowC, but I'll use this cheat for now since I haven't implemented all the functions yet.
	val window: GLFWWindowC? = glfwCreateWindow(1920, 1080, "KMP_GE") as GLFWWindowC?
	if (window == null) {
		glfwTerminate()
		println("ERROR - GLFWWindow failed to create!")
		exitProcess(EXIT_FAILURE)
	}

	glfwMakeContextCurrent(window)
	gladLoadGL(staticCFunction(::ktGlfwGetProcAddress))
	// V-Sync.
	glfwSwapInterval(1)

	println("OpenGL shader language version: ${glGetString(GL_SHADING_LANGUAGE_VERSION)}")

	while (!glfwWindowShouldClose(window)) {
		glfwSwapBuffers(window)
		glfwPollEvents()
	}

	glfwDestroyWindow(window)
	glfwTerminate()

	exitProcess(EXIT_SUCCESS)
}