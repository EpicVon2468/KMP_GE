@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop.glfw

import kotlinx.cinterop.ExperimentalForeignApi

@GLFW
actual inline fun glfwInit(): Boolean = glfw.glfwInit().glfwBoolean()

@GLFW
actual inline fun glfwTerminate() = glfw.glfwTerminate()

@GLFW
actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)

@GLFW
actual inline fun glfwSetErrorCallback(noinline callback: GLFWErrorFun?) {
	// FIXME: Can't return the old callback because `String.cstr` is `CValues<ByteVar>` and not `CPointer<ByteVar>`
	// FIXME: Even inlined, staticCFunction throws a fit.
	TODO("C interop throwing fits around function references. Please use the more verbose implementation for now.")
	//glfw.glfwSetErrorCallback(callback?.let { staticCFunction { e, d -> callback(e, d?.toKString()) } })
}

@GLFW
actual inline fun glfwMakeContextCurrent(window: GLFWWindow?) = glfw.glfwMakeContextCurrent(window.window)

@GLFW
actual inline fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?/* = null*/,
	share: GLFWWindow?/* = null*/
): GLFWWindow? = glfw.glfwCreateWindow(width, height, title, monitor.monitor, share.window).let(::GLFWWindowC)

@GLFW
actual inline fun glfwDestroyWindow(window: GLFWWindow?) = glfw.glfwDestroyWindow(window.window)

@GLFW
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFW
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)

@GLFW
actual inline fun glfwWindowShouldClose(window: GLFWWindow?): Boolean =
	glfw.glfwWindowShouldClose(window.window).glfwBoolean()