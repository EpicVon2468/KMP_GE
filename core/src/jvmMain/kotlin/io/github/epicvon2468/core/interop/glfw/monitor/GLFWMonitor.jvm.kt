package io.github.epicvon2468.core.interop.glfw.monitor

import io.github.epicvon2468.core.interop.Ptr
import io.github.epicvon2468.core.interop.glfw.GLFW

@GLFW
actual fun glfwGetPrimaryMonitor(): GLFWMonitor? = TODO()

@GLFW
actual fun glfwGetMonitorName(monitor: GLFWMonitor?): String? = TODO()

@GLFW
actual fun glfwSetMonitorUserPointer(monitor: GLFWMonitor?, pointer: Ptr<*>?): Unit = TODO()

@GLFW
actual fun glfwGetMonitorUserPointer(monitor: GLFWMonitor?): Ptr<*>? = TODO()

@GLFW
actual fun glfwGetVideoMode(monitor: GLFWMonitor?): GLFWVidMode? = TODO()

@GLFW
actual fun glfwSetGamma(monitor: GLFWMonitor?, gamma: Float): Unit = TODO()