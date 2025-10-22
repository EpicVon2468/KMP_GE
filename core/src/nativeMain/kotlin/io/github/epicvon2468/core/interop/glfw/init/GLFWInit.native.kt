@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE", "FunctionName", "ObjectPropertyName")
package io.github.epicvon2468.core.interop.glfw.init

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.glfwBoolean

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

@GLFW
actual const val GLFW_TRUE: Int = glfw.GLFW_TRUE

@GLFW
actual const val GLFW_FALSE: Int = glfw.GLFW_FALSE

@GLFW
actual inline fun glfwInit(): Boolean = glfw.glfwInit().glfwBoolean()

@GLFW
actual inline fun glfwTerminate() = glfw.glfwTerminate()

@GLFW
actual inline fun glfwInitHint(hint: Int, value: Int) = glfw.glfwInitHint(hint, value)

@GLFW
actual inline fun glfwGetVersionString(): String = glfw.glfwGetVersionString()?.toKString()
	?: error("Native `glfwGetVersionString()` call returned null! This is impossible as it should be a compile-time constant!")

var _callback: GLFWErrorFun? = null

fun __callback(error: Int, description: CPointer<ByteVar>?) {
	_callback?.invoke(error, description?.toKString())
}

@GLFW
actual inline fun glfwSetErrorCallback(noinline callback: GLFWErrorFun?) {
	// FIXME: Can't return the old callback because `String.cstr` is `CValues<ByteVar>` and not `CPointer<ByteVar>`
	// Annoyingly, staticCFunction doesn't let you reference variables, but it allows this... and it works.
	// If there's a more efficient or better way to do this in future, I'll change to use that instead.
	_callback = callback
	glfw.glfwSetErrorCallback(callback?.let { staticCFunction(::__callback) })
}

@GLFW
actual fun glfwGetPlatform(): Int = glfw.glfwGetPlatform()

@GLFW
actual fun glfwPlatformSupported(platform: Int): Boolean = glfw.glfwPlatformSupported(platform).glfwBoolean()