@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.kmp_ge.core

import gl.GL_ARRAY_BUFFER
import gl.GL_COLOR_BUFFER_BIT
import gl.GL_COMPILE_STATUS
import gl.GL_DEBUG_OUTPUT
import gl.GL_DEBUG_OUTPUT_SYNCHRONOUS
import gl.GL_FALSE
import gl.GL_FLOAT
import gl.GL_FRAGMENT_SHADER
import gl.GL_INVALID_ENUM
import gl.GL_INVALID_FRAMEBUFFER_OPERATION
import gl.GL_INVALID_OPERATION
import gl.GL_INVALID_VALUE
import gl.GL_LINK_STATUS
import gl.GL_NO_ERROR
import gl.GL_OUT_OF_MEMORY
import gl.GL_STACK_OVERFLOW
import gl.GL_STACK_UNDERFLOW
import gl.GL_STATIC_DRAW
import gl.GL_TRIANGLES
import gl.GL_TRUE
import gl.GL_VERTEX_SHADER
import gl.GLenum
import gl.GLint
import gl.GLsizei
import gl.GLuint
import gl.glAttachShader
import gl.glBindBuffer
import gl.glBindVertexArray
import gl.glBufferData
import gl.glClear
import gl.glCompileShader
import gl.glCreateProgram
import gl.glCreateShader
import gl.glDebugMessageCallback
import gl.glDrawArrays
import gl.glEnable
import gl.glEnableVertexAttribArray
import gl.glGenBuffers
import gl.glGenVertexArrays
import gl.glGetError
import gl.glGetProgramInfoLog
import gl.glGetProgramiv
import gl.glGetShaderInfoLog
import gl.glGetShaderiv
import gl.glLinkProgram
import gl.glUniform1f
import gl.glUseProgram
import gl.glVertexAttribPointer
import gl.glViewport

import glfw.GLFW_OPENGL_CORE_PROFILE
import glfw.glfwGetTime
import glfw.glfwGetVersion

import io.github.epicvon2468.kmp_ge.core.interop.ArrayPtr
import io.github.epicvon2468.kmp_ge.core.interop.exitProcess
import io.github.epicvon2468.kmp_ge.core.interop.EXIT_SUCCESS
import io.github.epicvon2468.kmp_ge.core.interop.EXIT_FAILURE
import io.github.epicvon2468.kmp_ge.core.interop.HMem
import io.github.epicvon2468.kmp_ge.core.interop.free
import io.github.epicvon2468.kmp_ge.core.interop.alloc
import io.github.epicvon2468.kmp_ge.core.interop.IntVar
import io.github.epicvon2468.kmp_ge.core.interop.OpaquePtr
import io.github.epicvon2468.kmp_ge.core.interop.Ptr
import io.github.epicvon2468.kmp_ge.core.interop.UIntVar
import io.github.epicvon2468.kmp_ge.core.interop.ptr
import io.github.epicvon2468.kmp_ge.core.interop.value
import io.github.epicvon2468.kmp_ge.core.interop.refTo
import io.github.epicvon2468.kmp_ge.core.interop.gl.glGetString
import io.github.epicvon2468.kmp_ge.core.interop.gl.GL_SHADING_LANGUAGE_VERSION
import io.github.epicvon2468.kmp_ge.core.interop.glfw.context.glfwSwapInterval
import io.github.epicvon2468.kmp_ge.core.interop.glfw.context.glfwMakeContextCurrent
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFWWindowC
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwCreateWindow
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwDestroyWindow
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwWindowShouldClose
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwPollEvents
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwSwapBuffers
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwSetFramebufferSizeCallback
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwGetFramebufferSize
import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.glfwGetVersionString
import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.glfwInit
import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.glfwSetErrorCallback
import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.glfwTerminate
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFW_CONTEXT_VERSION_MAJOR
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFW_CONTEXT_VERSION_MINOR
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFW_OPENGL_PROFILE
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.glfwWindowHint

import kmp_ge.cMain

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.get
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.sizeOf
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

import linearmaths.vec2

import platform.posix._IONBF
import platform.posix.setvbuf
import platform.posix.stdout

import kmp_ge.glGetUniformLocation_K
import kmp_ge.glShaderSource_K
import kmp_ge.loadGL

fun checkCompile(
	checker: Ptr<CFunction<(UInt, UInt, Ptr<IntVar>?) -> Unit>>,
	infoLog: Ptr<CFunction<(UInt, Int, Ptr<IntVar>?, ArrayPtr<ByteVar>?) -> Unit>>,
	status: Int,
	obj: UInt,
	name: String
) = memScoped {
	val cStatus: IntVar = alloc()
	checker.invoke(obj, status.toUInt(), cStatus.ptr)
	val success = cStatus.value.glBoolean()
	println("Obj '$name' ($obj) status: ${if (success) "success" else "failure"}.")
	if (!success) {
		println("Getting error log!")
		val errorLog: ArrayPtr<ByteVar> = allocArray(512)
		infoLog.invoke(obj, 512, null, errorLog)
		println("Error log: '${errorLog.toKString()}'")
		//exitProcess(EXIT_FAILURE)
	}
}

fun checkGLError(place: String) {
	val error: GLenum = glGetError!!.invoke()
	when (error.toInt()) {
		GL_NO_ERROR -> return
		GL_INVALID_ENUM -> "INVALID ENUM"
		GL_INVALID_VALUE -> "INVALID VALUE"
		GL_INVALID_OPERATION -> "INVALID OPERATION"
		GL_STACK_UNDERFLOW -> "STACK UNDERFLOW"
		GL_STACK_OVERFLOW -> "STACK OVERFLOW"
		GL_OUT_OF_MEMORY -> "OUT OF MEMORY"
		GL_INVALID_FRAMEBUFFER_OPERATION -> "INVALID FRAMEBUFFER OPERATION"
		else -> error("Couldn't match GL error code, got unknown value: '$error'!")
	}.let { println("GL errored at '$place'! Error: $it") }
}

// Testing with native stuff
@OptIn(ExperimentalForeignApi::class)
fun main() {
	// Auto flush (no buffer)
	setvbuf(stdout, null, _IONBF, 0U)

	val vec2: vec2 = HMem.allocArrayOf(-0.6f, -0.4f)
	require(vec2[0] == -0.6f)
	require(vec2[1] == -0.4f)
	HMem.free(vec2)

	println("GLFW version string: ${glfwGetVersionString()}")

	val version = IntArray(3)
	glfwGetVersion(version.refTo(0), version.refTo(1), version.refTo(2))
	println("Version: ${version.contentToString()}")

	cMain()

	glfwMain()
}

fun Int.glBoolean(): Boolean = when (this) {
	GL_TRUE -> true
	GL_FALSE -> false
	else -> error("Couldn't parse GL boolean '$this', expected either '$GL_TRUE' (true) or '$GL_FALSE' (false)!")
}

// Just some tests for GLFW interop.
// https://www.glfw.org/docs/latest/quick_guide.html
// https://dri.freedesktop.org/wiki/libGL/
// https://www.opengl.org/sdk/
// https://mesa3d.org/ (https://gitlab.freedesktop.org/mesa/mesa)
// https://learnopengl.com/code_viewer_gh.php?code=src/1.getting_started/2.2.hello_triangle_indexed/hello_triangle_indexed.cpp
// https://antongerdelan.net/opengl/hellotriangle.html
fun glfwMain(): Nothing {
	// To test this, window hint GLFW_CONTEXT_VERSION_MAJOR and GLFW_CONTEXT_VERSION_MINOR to something absurd like 99.
	glfwSetErrorCallback { errorCode: Int, description: String? ->
		println("ERROR - GLFWErrorFun: (errorCode: '$errorCode', message: '$description')")
	}

	if (!glfwInit()) {
		println("ERROR - Failed to initialise GLFW!")
		exitProcess(EXIT_FAILURE)
	}

	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4)
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 6)
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
	// Wouldn't normally be able to access GLFWWindowC, but I'll use this cheat for now since I haven't implemented all the functions yet.
	val window: GLFWWindowC? = glfwCreateWindow(640, 480, "KMP_GE") as GLFWWindowC?
	if (window == null) {
		println("ERROR - GLFWWindow failed to create!")
		glfwTerminate()
		exitProcess(EXIT_FAILURE)
	}

	glfwMakeContextCurrent(window)
	if (!loadGL()) {
		println("ERROR - Glad failed to load GL!")
		glfwTerminate()
		exitProcess(EXIT_FAILURE)
	}
	glfwSetFramebufferSizeCallback(window) { _, width: Int, height: Int ->
		glViewport!!.invoke(0, 0, width, height)
	}
	// V-Sync.
	glfwSwapInterval(1)

	glEnable!!.invoke(GL_DEBUG_OUTPUT.toUInt())
	glEnable!!.invoke(GL_DEBUG_OUTPUT_SYNCHRONOUS.toUInt())

	println("OpenGL shader language version: ${glGetString(GL_SHADING_LANGUAGE_VERSION)}")

	glDebugMessageCallback!!.invoke(
		staticCFunction { source: GLenum, type: GLenum, id: GLuint, severity: GLenum, length: GLsizei, message: ArrayPtr<ByteVar>?, userParam: OpaquePtr? ->
			println("GL debug callback invoked! Debug info:")
			println("DebugProc {\n\tsource = $source,\n\ttype = $type,\n\tid = $id,\n\tseverity = $severity,\n\tlength = $length,\n\tmessage = '${message?.toKString()}',\n\tuserParam = $userParam\n}")
		},
		null
	)

	val vertices: ArrayPtr<FloatVar> = HMem.allocArrayOf(
		0.0f, 0.5f, 0.0f,
		0.5f, -0.5f, 0.0f,
		-0.5f, -0.5f, 0.0f
	)

	val vertexBuffer: UIntVar = HMem.alloc()
	glGenBuffers!!.invoke(1, vertexBuffer.ptr)
	glBindBuffer!!.invoke(GL_ARRAY_BUFFER.toUInt(), vertexBuffer.value)
	glBufferData!!.invoke(GL_ARRAY_BUFFER.toUInt(), 9 * sizeOf<FloatVar>(), vertices, GL_STATIC_DRAW.toUInt())

	val vertexArray: UIntVar = HMem.alloc()
	glGenVertexArrays!!.invoke(1, vertexArray.ptr)
	glBindVertexArray!!.invoke(vertexArray.value)
	glEnableVertexAttribArray!!.invoke(0U)
	glBindBuffer!!.invoke(GL_ARRAY_BUFFER.toUInt(), vertexBuffer.value)
	glVertexAttribPointer!!.invoke(0U, 3, GL_FLOAT.toUInt(), GL_FALSE.toUByte(), 0, null)

	val vertexShader: UInt = glCreateShader!!.invoke(GL_VERTEX_SHADER.toUInt())
	glShaderSource_K(vertexShader, 1, VERTEX_SHADER, null)
	glCompileShader!!.invoke(vertexShader)
	checkGLError("glCompileShader vertex")

	checkCompile(glGetShaderiv!!, glGetShaderInfoLog!!, GL_COMPILE_STATUS, vertexShader, "Vertex Shader")
	checkGLError("checkCompile vertex")

	val fragmentShader: UInt = glCreateShader!!.invoke(GL_FRAGMENT_SHADER.toUInt())
	glShaderSource_K(fragmentShader, 1, FRAGMENT_SHADER, null)
	glCompileShader!!.invoke(fragmentShader)
	checkGLError("glCompileShader fragment")

	checkCompile(glGetShaderiv!!, glGetShaderInfoLog!!, GL_COMPILE_STATUS, fragmentShader, "Fragment Shader")
	checkGLError("checkCompile fragment")

	val program: UInt = glCreateProgram!!.invoke()
	glAttachShader!!.invoke(program, fragmentShader)
	glAttachShader!!.invoke(program, vertexShader)
	glLinkProgram!!.invoke(program)
	checkGLError("glLinkProgram")

	checkCompile(glGetProgramiv!!, glGetProgramInfoLog!!, GL_LINK_STATUS, program, "Shader Program")
	checkGLError("checkCompile program")

	val uTimeLocation: GLint = glGetUniformLocation_K(program, "time")

	// Do a first glViewport to fix alignment.
	memScoped {
		val width: IntVar = alloc()
		val height: IntVar = alloc()
		glfwGetFramebufferSize(window, width.ptr, height.ptr)
		glViewport!!.invoke(0, 0, width.value, height.value)
	}

	while (!glfwWindowShouldClose(window)) {
		glClear!!.invoke(GL_COLOR_BUFFER_BIT.toUInt())

		glUseProgram!!.invoke(program)
		glUniform1f!!.invoke(uTimeLocation, glfwGetTime().toFloat())
		glBindVertexArray!!.invoke(vertexArray.value)

		glDrawArrays!!.invoke(GL_TRIANGLES.toUInt(), 0, 3)

		glfwSwapBuffers(window)
		glfwPollEvents()
	}

	HMem.free(vertexArray)
	HMem.free(vertexBuffer)

	glfwDestroyWindow(window)
	glfwTerminate()

	exitProcess(EXIT_SUCCESS)
}