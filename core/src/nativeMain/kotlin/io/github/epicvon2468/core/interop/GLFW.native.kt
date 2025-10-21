@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

@GLFWWrapper
actual inline fun glfwInit(): Boolean = glfw.glfwInit().glfwBoolean()

@GLFWWrapper
actual inline fun glfwTerminate() = glfw.glfwTerminate()

@GLFWWrapper
actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)

@GLFWWrapper
actual inline fun glfwSetErrorCallback(noinline callback: GLFWErrorFun?) {
	// FIXME: Can't return the old callback because `String.cstr` is `CValues<ByteVar>` and not `CPointer<ByteVar>`
	// FIXME: Even inlined, staticCFunction throws a fit.
	TODO("C interop throwing fits around function references. Please use the more verbose implementation for now.")
	//glfw.glfwSetErrorCallback(callback?.let { staticCFunction { e, d -> callback(e, d?.toKString()) } })
}

/**
 * CInterop implementation of the [GLFWWindow] interface.
 */
@GLFWWrapper
data class GLFWWindowC(val window: CPointer<cnames.structs.GLFWwindow>?) : GLFWWindow

@GLFWWrapper
inline val GLFWWindow?.window: CPointer<cnames.structs.GLFWwindow>? get() = (this as? GLFWWindowC)?.window

/**
 * Cinterop implementation of the [GLFWMonitor] interface.
 */
@GLFWWrapper
data class GLFWMonitorC(val monitor: CPointer<cnames.structs.GLFWmonitor>?) : GLFWMonitor

@GLFWWrapper
inline val GLFWMonitor?.monitor: CPointer<cnames.structs.GLFWmonitor>? get() = (this as? GLFWMonitorC)?.monitor

@GLFWWrapper
actual inline fun glfwMakeContextCurrent(window: GLFWWindow?) = glfw.glfwMakeContextCurrent(window.window)

@GLFWWrapper
actual inline fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?/* = null*/,
	share: GLFWWindow?/* = null*/
): GLFWWindow? = glfw.glfwCreateWindow(width, height, title, monitor.monitor, share.window).let(::GLFWWindowC)

@GLFWWrapper
actual inline fun glfwDestroyWindow(window: GLFWWindow?) = glfw.glfwDestroyWindow(window.window)

@GLFWWrapper
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFWWrapper
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)

@GLFWWrapper
actual inline fun glfwWindowShouldClose(window: GLFWWindow?): Boolean =
	glfw.glfwWindowShouldClose(window.window).glfwBoolean()

@GLFWWrapper
actual inline val GLFW_TRUE: Int get() = glfw.GLFW_TRUE

@GLFWWrapper
actual inline val GLFW_FALSE: Int get() = glfw.GLFW_FALSE