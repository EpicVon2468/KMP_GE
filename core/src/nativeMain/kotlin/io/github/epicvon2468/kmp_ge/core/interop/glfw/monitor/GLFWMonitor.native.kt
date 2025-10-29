@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop.glfw.monitor

import io.github.epicvon2468.kmp_ge.core.interop.Ptr
import io.github.epicvon2468.kmp_ge.core.interop.glfw.GLFW

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

/**
 * Cinterop implementation of the [GLFWMonitor] interface.
 */
@GLFW
data class GLFWMonitorC(val monitor: CPointer<cnames.structs.GLFWmonitor>) : GLFWMonitor

@GLFW
inline val GLFWMonitor?.monitor: CPointer<cnames.structs.GLFWmonitor>? get() = (this as? GLFWMonitorC)?.monitor

@GLFW
data class GLFWVidModeC(val vidMode: CPointer<glfw.GLFWvidmode>) : GLFWVidMode

@GLFW
inline val GLFWVidMode?.vidMode: CPointer<glfw.GLFWvidmode>? get() = (this as? GLFWVidModeC)?.vidMode

@GLFW
actual inline fun glfwGetPrimaryMonitor(): GLFWMonitor? = glfw.glfwGetPrimaryMonitor()?.let(::GLFWMonitorC)

@GLFW
actual inline fun glfwGetMonitorName(monitor: GLFWMonitor?): String? =
	glfw.glfwGetMonitorName(monitor.monitor)?.toKString()

@GLFW
actual inline fun glfwSetMonitorUserPointer(monitor: GLFWMonitor?, pointer: Ptr<*>?) =
	glfw.glfwSetMonitorUserPointer(monitor.monitor, pointer)

@GLFW
actual inline fun glfwGetMonitorUserPointer(monitor: GLFWMonitor?): Ptr<*>? =
	glfw.glfwGetMonitorUserPointer(monitor.monitor)

@GLFW
actual inline fun glfwGetVideoMode(monitor: GLFWMonitor?): GLFWVidMode? =
	glfw.glfwGetVideoMode(monitor.monitor)?.let(::GLFWVidModeC)

@GLFW
actual inline fun glfwSetGamma(monitor: GLFWMonitor?, gamma: Float) = glfw.glfwSetGamma(monitor.monitor, gamma)