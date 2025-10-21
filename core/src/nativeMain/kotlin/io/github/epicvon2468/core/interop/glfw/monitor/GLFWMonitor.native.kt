@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core.interop.glfw.monitor

import io.github.epicvon2468.core.interop.glfw.GLFW

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi

/**
 * Cinterop implementation of the [GLFWMonitor] interface.
 */
@GLFW
data class GLFWMonitorC(val monitor: CPointer<cnames.structs.GLFWmonitor>?) : GLFWMonitor

@GLFW
inline val GLFWMonitor?.monitor: CPointer<cnames.structs.GLFWmonitor>? get() = (this as? GLFWMonitorC)?.monitor