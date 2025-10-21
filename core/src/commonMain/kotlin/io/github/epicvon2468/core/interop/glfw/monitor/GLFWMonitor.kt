package io.github.epicvon2468.core.interop.glfw.monitor

import io.github.epicvon2468.core.interop.Ptr
import io.github.epicvon2468.core.interop.glfw.GLFW

// https://www.glfw.org/docs/3.4/group__monitor.html

/**
 * Opaque monitor object.
 *
 * @see monitor_object
 *
 * @since Added in version 3.0.
 */
@GLFW
interface GLFWMonitor

@GLFW
interface GLFWVidMode

// GLFWMonitor** glfwGetMonitors(int *count)

@GLFW
expect fun glfwGetPrimaryMonitor(): GLFWMonitor?

// void glfwGetMonitorPos(GLFWMonitor *monitor, int *xPos, int *yPos)

// void glfwGetMonitorWorkarea(GLFWMonitor *monitor, int *xPos, int *yPos, int *width, int *height)

// void glfwGetMonitorPhysicalSize(GLFWMonitor *monitor, int *widthMM, int *heightMM)

// void glfwGetMonitorContentScale(GLFWMonitor *monitor, float *xScale, float *yScale)

@GLFW
expect fun glfwGetMonitorName(monitor: GLFWMonitor?): String?

@GLFW
expect fun glfwSetMonitorUserPointer(monitor: GLFWMonitor?, pointer: Ptr<*>?)

@GLFW
expect fun glfwGetMonitorUserPointer(monitor: GLFWMonitor?): Ptr<*>?

// GLFWMonitorFun glfwSetMonitorCallback(GLFWMonitorFun callback)

// const GLFWVidMode glfwGetVideoModes(GLFWMonitor *monitor, int *count)

@GLFW
expect fun glfwGetVideoMode(monitor: GLFWMonitor?): GLFWVidMode?

@GLFW
expect fun glfwSetGamma(monitor: GLFWMonitor?, gamma: Float)

// const GLFWGammaRamp* glfwGetGammaRamp(GLFWMonitor *monitor)

// void glfwSetGammaRamp(GLFWMonitor *monitor, const GLFWGammaRamp *ramp)