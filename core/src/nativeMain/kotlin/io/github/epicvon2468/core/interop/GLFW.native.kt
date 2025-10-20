@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

@GLFWWrapper
actual inline fun glfwInit(): Boolean = glfw.glfwInit() == glfw.GLFW_TRUE

@GLFWWrapper
actual inline fun glfwTerminate() = glfw.glfwTerminate()

@GLFWWrapper
actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)

@GLFWWrapper
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?) {
	// FIXME: Can't return the old callback because `String.cstr` is `CValues<ByteVar>` and not `CPointer<ByteVar>`
	// FIXME: Even inlined, staticCFunction throws a fit.
	TODO("C interop throwing fits around function references. Please use the more verbose implementation for now.")
	@Suppress("KotlinUnreachableCode")
	glfw.glfwSetErrorCallback(if (callback == null) null else staticCFunction { e, d -> callback(e, d?.toKString()) })
}