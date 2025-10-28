@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core

import gl.GLADapiproc
import gl.GL_ARRAY_BUFFER
import gl.GL_COLOR_BUFFER_BIT
import gl.GL_COMPILE_STATUS
import gl.GL_DEBUG_OUTPUT
import gl.GL_DEBUG_OUTPUT_SYNCHRONOUS
import gl.GL_FALSE
import gl.GL_FLOAT
import gl.GL_FRAGMENT_SHADER
import gl.GL_INFO_LOG_LENGTH
import gl.GL_INVALID_ENUM
import gl.GL_INVALID_FRAMEBUFFER_OPERATION
import gl.GL_INVALID_OPERATION
import gl.GL_INVALID_VALUE
import gl.GL_NO_ERROR
import gl.GL_OUT_OF_MEMORY
import gl.GL_STACK_OVERFLOW
import gl.GL_STACK_UNDERFLOW
import gl.GL_STATIC_DRAW
import gl.GL_TRIANGLES
import gl.GL_TRUE
import gl.GL_VERTEX_SHADER
import gl.GLenum
import gl.GLenumVar
import gl.GLfloat
import gl.GLfloatVar
import gl.GLint
import gl.GLintVar
import gl.GLsizei
import gl.GLubyte
import gl.GLubyteVar
import gl.GLuint
import gl.GLuintVar
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
import gl.glGetAttribLocation
import gl.glGetError
import gl.glGetProgramInfoLog
import gl.glGetProgramiv
import gl.glGetShaderInfoLog
import gl.glGetShaderiv
import gl.glGetUniformLocation
import gl.glLinkProgram
import gl.glShaderSourceK
import gl.glUniformMatrix4fv
import gl.glUseProgram
import gl.glVertexAttribPointer
import gl.glViewport
import gl.gladLoadGL
import glfw.GLFW_OPENGL_CORE_PROFILE
import glfw.glfwGetFramebufferSize
import glfw.glfwGetProcAddress
import glfw.glfwGetTime
import glfw.glfwSetFramebufferSizeCallback

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
import io.github.epicvon2468.core.interop.glfw.window.GLFW_CONTEXT_VERSION_MAJOR
import io.github.epicvon2468.core.interop.glfw.window.GLFW_CONTEXT_VERSION_MINOR
import io.github.epicvon2468.core.interop.glfw.window.GLFW_OPENGL_PROFILE
import io.github.epicvon2468.core.interop.glfw.window.glfwWindowHint

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CArrayPointer
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.FloatVar
import kotlinx.cinterop.IntVar
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.alloc
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.cstr
import kotlinx.cinterop.free
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.refTo
import kotlinx.cinterop.get
import kotlinx.cinterop.invoke
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.set
import kotlinx.cinterop.sizeOf
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import kotlinx.cinterop.value

import linearmaths.Vertex
import linearmaths.cSizeOf
import linearmaths.mat4x4
import linearmaths.mat4x4_identity
import linearmaths.mat4x4_mul
import linearmaths.mat4x4_ortho
import linearmaths.mat4x4_rotate_Z
import linearmaths.vec2
import linearmaths.vec3
import linearmaths.vertexColOffset
import linearmaths.vertexPosOffset

import platform.posix.EXIT_FAILURE
import platform.posix.EXIT_SUCCESS

const val VERTEX_SHADER: String =
	"#version 330\n" +
	"uniform mat4 MVP;\n" +
	"in vec3 vCol;\n" +
	"in vec2 vPos;\n" +
	"out vec3 color;\n" +
	"void main() {\n" +
	"    gl_Position = MVP * vec4(vPos, 0.0, 1.0);\n" +
	"    color = vCol;\n" +
	"}\n"

const val FRAGMENT_SHADER: String =
	"#version 330\n" +
	"in vec3 color;\n" +
	"out vec4 fragment;\n" +
	"void main() {\n" +
	"    fragment = vec4(color, 1.0);\n" +
	"}\n"

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

fun checkCompile(
	checker: CPointer<CFunction<(UInt, UInt, CPointer<IntVar>?) -> Unit>>,
	infoLog: CPointer<CFunction<(UInt, Int, CPointer<IntVar>?, CPointer<ByteVar>?) -> Unit>>,
	obj: GLuint,
	name: String
) = memScoped {
	val cStatus: IntVar = alloc()
	checker.invoke(obj, GL_COMPILE_STATUS.toUInt(), cStatus.ptr)
	val success = cStatus.value.glBoolean()
	println("Obj '$name' ($obj) compile status: ${if (success) "success" else "failure"}.")
	if (!success) {
		println("Getting error log!")
		val errorLog: CArrayPointer<ByteVar> = allocArray(512)
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
//	val vec2: vec2 = nativeHeap.allocArrayOf(-0.6f, -0.4f)
//	nativeHeap.free(vec2)
//
//	println("GLFW version string: ${glfwGetVersionString()}")
//
//	val version = IntArray(3)
//	glfwGetVersion(version.refTo(0), version.refTo(1), version.refTo(2))
//	println("Version: ${version.contentToString()}")

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
		glfwTerminate()
		println("ERROR - GLFWWindow failed to create!")
		exitProcess(EXIT_FAILURE)
	}

	glfwMakeContextCurrent(window)
	gladLoadGL(staticCFunction(::ktGlfwGetProcAddress))
	glfwSetFramebufferSizeCallback(window.window, staticCFunction { _, width: Int, height: Int ->
		glViewport!!.invoke(0, 0, width, height)
	})
	// V-Sync.
	glfwSwapInterval(1)

	// WHY IN THE ACTUAL FUCK IS THIS NOT ON BY DEFAULT?!?!?!
	glEnable!!.invoke(GL_DEBUG_OUTPUT.toUInt())
	glEnable!!.invoke(GL_DEBUG_OUTPUT_SYNCHRONOUS.toUInt())

	println("OpenGL shader language version: ${glGetString(GL_SHADING_LANGUAGE_VERSION)}")

	glDebugMessageCallback!!.invoke(
		staticCFunction { source: GLenum, type: GLenum, id: GLuint, severity: GLenum, length: GLsizei, message: CPointer<ByteVar>?, userParam: COpaquePointer? ->
			println("GL debug callback invoked! Debug info:")
			println("DebugProc {\n\tsource = $source,\n\ttype = $type,\n\tid = $id,\n\tseverity = $severity,\n\tlength = $length,\n\tmessage = '${message?.toKString()}',\n\tuserParam = $userParam\n}")
		},
		null
	)

	memScoped {
		val vertexBuffer: GLuintVar = alloc()
		glGenBuffers!!.invoke(1, vertexBuffer.ptr)
		checkGLError("glGenBuffers")
		glBindBuffer!!.invoke(GL_ARRAY_BUFFER.toUInt(), vertexBuffer.value)
		checkGLError("glBindBuffer")
		glBufferData!!.invoke(GL_ARRAY_BUFFER.toUInt(), cSizeOf(vertices).toLong(), vertices, GL_STATIC_DRAW.toUInt())
		checkGLError("glBufferData")
	}

	val vertexShader: GLuint = glCreateShader!!.invoke(GL_VERTEX_SHADER.toUInt())
	checkGLError("glCreateShader vertex")
	glShaderSourceK(vertexShader, 1, VERTEX_SHADER, null)
	checkGLError("glShaderSource vertex")
	glCompileShader!!.invoke(vertexShader)
	checkGLError("glCompileShader vertex")

	// Obj 'Vertex Shader' (1) compile status: success.
	checkCompile(glGetShaderiv!!, glGetShaderInfoLog!!, vertexShader, "Vertex Shader")
	checkGLError("checkCompile vertex")

	val fragmentShader: GLuint = glCreateShader!!.invoke(GL_FRAGMENT_SHADER.toUInt())
	checkGLError("glCreateShader fragment")
	glShaderSourceK(fragmentShader, 1, FRAGMENT_SHADER, null)
	checkGLError("glShaderSource fragment")
	glCompileShader!!.invoke(fragmentShader)
	checkGLError("glCompileShader fragment")

	// Obj 'Fragment Shader' (2) compile status: success.
	checkCompile(glGetShaderiv!!, glGetShaderInfoLog!!, fragmentShader, "Fragment Shader")
	checkGLError("checkCompile fragment")

	// This is the failure point.
	val program: GLuint = glCreateProgram!!.invoke()
	checkGLError("glCreateProgram")
	glAttachShader!!.invoke(program, vertexShader)
	checkGLError("glAttachShader vertex")
	glAttachShader!!.invoke(program, fragmentShader)
	checkGLError("glAttachShader fragment")
	glLinkProgram!!.invoke(program)
	checkGLError("glLinkProgram")

	// Error only logs at this point
	// Obj 'Shader Program' (3) compile status: failure.
	checkCompile(glGetProgramiv!!, glGetProgramInfoLog!!, program, "Shader Program")
	checkGLError("checkCompile program")

	val (mvpLocation: GLint, vPosLocation: GLint, vColLocation: GLint) = memScoped {
		Triple(
			glGetUniformLocation!!.invoke(program, "MVP".cstr.ptr),
			glGetAttribLocation!!.invoke(program, "vPos".cstr.ptr),
			glGetAttribLocation!!.invoke(program, "vCol".cstr.ptr)
		)
	}
	checkGLError("glGetUniformLocation, glGetAttribLocation x2")

	val vertexArray: GLuintVar = nativeHeap.alloc()
	glGenVertexArrays!!.invoke(1, vertexArray.ptr)
	glBindVertexArray!!.invoke(vertexArray.value)
	glEnableVertexAttribArray!!.invoke(vPosLocation.toUInt())
	glVertexAttribPointer!!.invoke(vPosLocation.toUInt(), 2, GL_FLOAT.toUInt(), GL_FALSE.toUByte(), sizeOf<Vertex>().toInt(), vertexPosOffset())
	glEnableVertexAttribArray!!.invoke(vColLocation.toUInt())
	glVertexAttribPointer!!.invoke(vColLocation.toUInt(), 3, GL_FLOAT.toUInt(), GL_FALSE.toUByte(), sizeOf<Vertex>().toInt(), vertexColOffset())

	while (!glfwWindowShouldClose(window)) {
		val width: IntVar = nativeHeap.alloc()
		val height: IntVar = nativeHeap.alloc()
		glfwGetFramebufferSize(window.window, width.ptr, height.ptr)
		val ratio: Float = (width.value / height.value).toFloat()

		glViewport!!.invoke(0, 0, width.value, height.value)
		glClear!!.invoke(GL_COLOR_BUFFER_BIT.toUInt())

		nativeHeap.free(width)
		nativeHeap.free(height)

		memScoped {
			val m: CArrayPointer<FloatVar> = allocArray(4L)
			val p: mat4x4 = allocArray(4L)
			val mvp: mat4x4 = allocArray(4L)
			mat4x4_identity(m)
			mat4x4_rotate_Z(m, m, glfwGetTime().toFloat())
			mat4x4_ortho(p, -ratio, ratio, -1.0f, 1.0f, 1.0f, -1.0f)
			mat4x4_mul(mvp, p, m)

			glUseProgram!!.invoke(program)
			glUniformMatrix4fv!!.invoke(mvpLocation, 1, GL_FALSE.toUByte(), mvp)
		}
		glBindVertexArray!!.invoke(vertexArray.value)
		glDrawArrays!!.invoke(GL_TRIANGLES.toUInt(), 0, 3)

		glfwSwapBuffers(window)
		glfwPollEvents()
	}

	nativeHeap.free(vertexArray)

	glfwDestroyWindow(window)
	glfwTerminate()

	nativeHeap.free(vertices)

	exitProcess(EXIT_SUCCESS)
}