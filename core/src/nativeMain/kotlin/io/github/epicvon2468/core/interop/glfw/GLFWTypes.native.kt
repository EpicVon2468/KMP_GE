@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core.interop.glfw

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi


/**
 * CInterop implementation of the [GLFWWindow] interface.
 */
@GLFW
data class GLFWWindowC(val window: CPointer<cnames.structs.GLFWwindow>?) : GLFWWindow

@GLFW
inline val GLFWWindow?.window: CPointer<cnames.structs.GLFWwindow>? get() = (this as? GLFWWindowC)?.window

/**
 * Cinterop implementation of the [GLFWMonitor] interface.
 */
@GLFW
data class GLFWMonitorC(val monitor: CPointer<cnames.structs.GLFWmonitor>?) : GLFWMonitor

@GLFW
inline val GLFWMonitor?.monitor: CPointer<cnames.structs.GLFWmonitor>? get() = (this as? GLFWMonitorC)?.monitor