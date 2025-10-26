@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core

import gl.GLADapiproc
import gl.gladLoadGL
import glfw.glfwGetProcAddress
import glfw.glfwGetVersion

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
import kotlinx.cinterop.CArrayPointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.free
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.refTo
import kotlinx.cinterop.get
import kotlinx.cinterop.set
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

import linearmaths.Vertex
import linearmaths.vec2
import linearmaths.vec3

import platform.posix.EXIT_FAILURE
import platform.posix.EXIT_SUCCESS

const val VERTEX_SHADER: String = "#version 330\nuniform mat4 MVP;\nin vec3 vCol;\nin vec2 vPos;\nout vec3 color;\nvoid main() {\ngl_Position = MVP * vec4(vPos, 0.0, 1.0);\ncolor = vCol;\n}"

const val FRAGMENT_SHADER: String = "#version 330\nin vec3 color;\nout vec4 fragment;\nvoid main() {\nfragment = vec4(color, 1.0);\n}"

fun vec2.set(first: Float, second: Float) {
	this[0] = first
	this[1] = second
}

fun vec2.set(value: Pair<Float, Float>) = this.set(value.first, value.second)

fun vec3.set(first: Float, second: Float, third: Float) {
	this[0] = first
	this[1] = second
	this[2] = third
}

fun vec3.set(value: Triple<Float, Float, Float>) = this.set(value.first, value.second, value.third)

fun NativePlacement.vertexArrayOf(
	size: Long,
	init: Vertex.(index: Long) -> Unit
): CArrayPointer<Vertex> = this.allocArray<Vertex>(size).also { array: CArrayPointer<Vertex> ->
	for (index in 0..<size) array[index].init(index)
}

fun NativePlacement.vertexArrayOf(
	size: Long,
	vararg entries: Vertex.(index: Long) -> Unit
): CArrayPointer<Vertex> = this.vertexArrayOf(size) { entries[it.toInt()](this, it) }

val vertices: CArrayPointer<Vertex> = nativeHeap.vertexArrayOf(
	3L,
	{
		this.pos.set(-0.6f, -0.4f)
		this.col.set(1.0f, 0.0f, 0.0f)
	},
	{
		this.pos.set(0.6f, -0.4f)
		this.col.set(0.0f, 1.0f, 0.0f)
	},
	{
		this.pos.set(0.0f,  0.6f)
		this.col.set(0.0f, 0.0f, 1.0f)
	}
)

fun ktGlfwGetProcAddress(ptr: CPointer<ByteVar>?): GLADapiproc? = glfwGetProcAddress(ptr?.toKString())

// Just some tests for GLFW interop.
// https://www.glfw.org/docs/latest/quick_guide.html
// https://dri.freedesktop.org/wiki/libGL/
// https://www.opengl.org/sdk/
// https://mesa3d.org/ (https://gitlab.freedesktop.org/mesa/mesa)
@OptIn(ExperimentalForeignApi::class)
fun main() {
	val vec2: vec2 = nativeHeap.allocArrayOf(-0.6f, -0.4f)
	nativeHeap.free(vec2)

	println("GLFW version string: ${glfwGetVersionString()}")

	val version = IntArray(3)
	glfwGetVersion(version.refTo(0), version.refTo(1), version.refTo(2))
	println("Version: ${version.contentToString()}")

	//glBufferData!!.invoke(GL_ARRAY_BUFFER.toUInt(), TODO(), vertices, GL_STATIC_DRAW.toUInt())

	glfwMain()
}

fun glfwMain(): Nothing {
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