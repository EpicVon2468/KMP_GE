@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop.glfw.window

import io.github.epicvon2468.kmp_ge.core.interop.glfw.GLFW
import io.github.epicvon2468.kmp_ge.core.interop.Ptr
import io.github.epicvon2468.kmp_ge.core.interop.glfw.glfwBoolean
import io.github.epicvon2468.kmp_ge.core.interop.glfw.monitor.monitor
import io.github.epicvon2468.kmp_ge.core.interop.glfw.monitor.GLFWMonitor
import io.github.epicvon2468.kmp_ge.core.interop.glfw.monitor.GLFWMonitorC

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

@GLFW
actual const val GLFW_FOCUSED: Int = glfw.GLFW_FOCUSED

@GLFW
actual const val GLFW_ICONIFIED: Int = glfw.GLFW_ICONIFIED

@GLFW
actual const val GLFW_RESIZABLE: Int = glfw.GLFW_RESIZABLE

@GLFW
actual const val GLFW_VISIBLE: Int = glfw.GLFW_VISIBLE

@GLFW
actual const val GLFW_DECORATED: Int = glfw.GLFW_DECORATED

@GLFW
actual const val GLFW_AUTO_ICONIFY: Int = glfw.GLFW_AUTO_ICONIFY

@GLFW
actual const val GLFW_FLOATING: Int = glfw.GLFW_FLOATING

@GLFW
actual const val GLFW_MAXIMISED: Int = glfw.GLFW_MAXIMIZED

@GLFW
actual const val GLFW_CENTRE_CURSOR: Int = glfw.GLFW_CENTER_CURSOR

@GLFW
actual const val GLFW_TRANSPARENT_FRAMEBUFFER: Int = glfw.GLFW_TRANSPARENT_FRAMEBUFFER

@GLFW
actual const val GLFW_HOVERED: Int = glfw.GLFW_HOVERED

@GLFW
actual const val GLFW_FOCUS_ON_SHOW: Int = glfw.GLFW_FOCUS_ON_SHOW

@GLFW
actual const val GLFW_MOUSE_PASSTHROUGH: Int = glfw.GLFW_MOUSE_PASSTHROUGH

@GLFW
actual const val GLFW_POSITION_X: Int = glfw.GLFW_POSITION_X

@GLFW
actual const val GLFW_POSITION_Y: Int = glfw.GLFW_POSITION_Y

@GLFW
actual const val GLFW_RED_BITS: Int = glfw.GLFW_RED_BITS

@GLFW
actual const val GLFW_GREEN_BITS: Int = glfw.GLFW_GREEN_BITS

@GLFW
actual const val GLFW_BLUE_BITS: Int = glfw.GLFW_BLUE_BITS

@GLFW
actual const val GLFW_ALPHA_BITS: Int = glfw.GLFW_ALPHA_BITS

@GLFW
actual const val GLFW_DEPTH_BITS: Int = glfw.GLFW_DEPTH_BITS

@GLFW
actual const val GLFW_STENCIL_BITS: Int = glfw.GLFW_STENCIL_BITS

@GLFW
actual const val GLFW_ACCUM_RED_BITS: Int = glfw.GLFW_ACCUM_RED_BITS

@GLFW
actual const val GLFW_ACCUM_GREEN_BITS: Int = glfw.GLFW_ACCUM_GREEN_BITS

@GLFW
actual const val GLFW_ACCUM_BLUE_BITS: Int = glfw.GLFW_ACCUM_BLUE_BITS

@GLFW
actual const val GLFW_ACCUM_ALPHA_BITS: Int = glfw.GLFW_ACCUM_ALPHA_BITS

@GLFW
actual const val GLFW_AUX_BUFFERS: Int = glfw.GLFW_AUX_BUFFERS

@GLFW
actual const val GLFW_STEREO: Int = glfw.GLFW_STEREO

@GLFW
actual const val GLFW_SAMPLES: Int = glfw.GLFW_SAMPLES

@GLFW
actual const val GLFW_SRGB_CAPABLE: Int = glfw.GLFW_SRGB_CAPABLE

@GLFW
actual const val GLFW_REFRESH_RATE: Int = glfw.GLFW_REFRESH_RATE

@GLFW
actual const val GLFW_DOUBLEBUFFER: Int = glfw.GLFW_DOUBLEBUFFER

@GLFW
actual const val GLFW_CLIENT_API: Int = glfw.GLFW_CLIENT_API

@GLFW
actual const val GLFW_CONTEXT_VERSION_MAJOR: Int = glfw.GLFW_CONTEXT_VERSION_MAJOR

@GLFW
actual const val GLFW_CONTEXT_VERSION_MINOR: Int = glfw.GLFW_CONTEXT_VERSION_MINOR

@GLFW
actual const val GLFW_CONTEXT_REVISION: Int = glfw.GLFW_CONTEXT_REVISION

@GLFW
actual const val GLFW_CONTEXT_ROBUSTNESS: Int = glfw.GLFW_CONTEXT_ROBUSTNESS

@GLFW
actual const val GLFW_OPENGL_FORWARD_COMPAT: Int = glfw.GLFW_OPENGL_FORWARD_COMPAT

@GLFW
actual const val GLFW_CONTEXT_DEBUG: Int = glfw.GLFW_CONTEXT_DEBUG

@GLFW
actual const val GLFW_OPENGL_DEBUG_CONTEXT: Int = GLFW_CONTEXT_DEBUG

@GLFW
actual const val GLFW_OPENGL_PROFILE: Int = glfw.GLFW_OPENGL_PROFILE

@GLFW
actual const val GLFW_CONTEXT_RELEASE_BEHAVIOUR: Int = glfw.GLFW_CONTEXT_RELEASE_BEHAVIOR

@GLFW
actual const val GLFW_CONTEXT_NO_ERROR: Int = glfw.GLFW_CONTEXT_NO_ERROR

@GLFW
actual const val GLFW_CONTEXT_CREATION_API: Int = glfw.GLFW_CONTEXT_CREATION_API

@GLFW
actual const val GLFW_SCALE_TO_MONITOR: Int = glfw.GLFW_SCALE_TO_MONITOR

@GLFW
actual const val GLFW_SCALE_FRAMEBUFFER: Int = glfw.GLFW_SCALE_FRAMEBUFFER

@GLFW
actual const val GLFW_COCOA_RETINA_FRAMEBUFFER: Int = glfw.GLFW_COCOA_RETINA_FRAMEBUFFER

@GLFW
actual const val GLFW_COCOA_FRAME_NAME: Int = glfw.GLFW_COCOA_FRAME_NAME

@GLFW
actual const val GLFW_COCOA_GRAPHICS_SWITCHING: Int = glfw.GLFW_COCOA_GRAPHICS_SWITCHING

@GLFW
actual const val GLFW_X11_CLASS_NAME: Int = glfw.GLFW_X11_CLASS_NAME

@GLFW
actual const val GLFW_X11_INSTANCE_NAME: Int = glfw.GLFW_X11_INSTANCE_NAME

@GLFW
actual const val GLFW_WIN32_KEYBOARD_MENU: Int = glfw.GLFW_WIN32_KEYBOARD_MENU

@GLFW
actual const val GLFW_WIN32_SHOWDEFAULT: Int = glfw.GLFW_WIN32_SHOWDEFAULT

@GLFW
actual const val GLFW_WAYLAND_APP_ID: Int = glfw.GLFW_WAYLAND_APP_ID

/**
 * CInterop implementation of the [GLFWWindow] interface.
 */
@GLFW
data class GLFWWindowC(val window: CPointer<cnames.structs.GLFWwindow>) : GLFWWindow

@GLFW
inline val GLFWWindow?.window: CPointer<cnames.structs.GLFWwindow>? get() = (this as? GLFWWindowC)?.window

/**
 * CInterop implementation of the [GLFWImage] interface.
 */
@GLFW
data class GLFWImageC(val image: CValuesRef<glfw.GLFWimage>) : GLFWImage

@GLFW
inline val GLFWImage?.image: CValuesRef<glfw.GLFWimage>? get() = (this as? GLFWImageC)?.image

@GLFW
actual inline fun glfwDefaultWindowHints() = glfw.glfwDefaultWindowHints()

@GLFW
actual inline fun glfwWindowHint(hint: Int, value: Int) = glfw.glfwWindowHint(hint, value)

@GLFW
actual inline fun glfwWindowHintString(hint: Int, value: String?) = glfw.glfwWindowHintString(hint, value)

@GLFW
actual inline fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?/* = null*/,
	share: GLFWWindow?/* = null*/
): GLFWWindow? = glfw.glfwCreateWindow(width, height, title, monitor.monitor, share.window)?.let(::GLFWWindowC)

@GLFW
actual inline fun glfwDestroyWindow(window: GLFWWindow?) = glfw.glfwDestroyWindow(window.window)

@GLFW
actual inline fun glfwWindowShouldClose(window: GLFWWindow?): Boolean =
	glfw.glfwWindowShouldClose(window.window).glfwBoolean()

@GLFW
actual inline fun glfwSetWindowShouldClose(window: GLFWWindow?, value: Boolean) =
	glfw.glfwSetWindowShouldClose(window.window, value.glfwBoolean())

@GLFW
actual inline fun glfwGetWindowTitle(window: GLFWWindow?): String? = glfw.glfwGetWindowTitle(window.window)?.toKString()

@GLFW
actual inline fun glfwSetWindowTitle(window: GLFWWindow?, title: String?) =
	glfw.glfwSetWindowTitle(window.window, title)

@GLFW
actual inline fun glfwSetWindowIcon(window: GLFWWindow?, count: Int, images: GLFWImage?) =
	glfw.glfwSetWindowIcon(window.window, count, images.image)

@GLFW
actual inline fun glfwSetWindowPos(window: GLFWWindow?, xPos: Int, yPos: Int) =
	glfw.glfwSetWindowPos(window.window, xPos, yPos)

@GLFW
actual inline fun glfwSetWindowSizeLimits(
	window: GLFWWindow?,
	minWidth: Int,
	minHeight: Int,
	maxWidth: Int,
	maxHeight: Int
) = glfw.glfwSetWindowSizeLimits(window.window, minWidth, minHeight, maxWidth, maxHeight)

@GLFW
actual inline fun glfwSetWindowAspectRatio(window: GLFWWindow?, numer: Int, demon: Int) =
	glfw.glfwSetWindowAspectRatio(window.window, numer, demon)

@GLFW
actual inline fun glfwSetWindowSize(window: GLFWWindow?, width: Int, height: Int) =
	glfw.glfwSetWindowSize(window.window, width, height)

@GLFW
actual inline fun glfwGetWindowOpacity(window: GLFWWindow?): Float = glfw.glfwGetWindowOpacity(window.window)

@GLFW
actual inline fun glfwSetWindowOpacity(window: GLFWWindow?, opacity: Float) =
	glfw.glfwSetWindowOpacity(window.window, opacity)

@GLFW
actual inline fun glfwIconifyWindow(window: GLFWWindow?) = glfw.glfwIconifyWindow(window.window)

@GLFW
actual inline fun glfwRestoreWindow(window: GLFWWindow?) = glfw.glfwRestoreWindow(window.window)

@GLFW
actual inline fun glfwMaximiseWindow(window: GLFWWindow?) = glfw.glfwMaximizeWindow(window.window)

@GLFW
actual inline fun glfwShowWindow(window: GLFWWindow?) = glfw.glfwShowWindow(window.window)

@GLFW
actual inline fun glfwHideWindow(window: GLFWWindow?) = glfw.glfwHideWindow(window.window)

@GLFW
actual inline fun glfwFocusWindow(window: GLFWWindow?) = glfw.glfwFocusWindow(window.window)

@GLFW
actual inline fun glfwRequestWindowAttention(window: GLFWWindow?) = glfw.glfwRequestWindowAttention(window.window)

@GLFW
actual inline fun glfwGetWindowMonitor(window: GLFWWindow?): GLFWMonitor? =
	glfw.glfwGetWindowMonitor(window.window)?.let(::GLFWMonitorC)

@GLFW
actual inline fun glfwSetWindowMonitor(
	window: GLFWWindow?,
	monitor: GLFWMonitor?,
	xPos: Int,
	yPos: Int,
	width: Int,
	height: Int,
	refreshRate: Int
) = glfw.glfwSetWindowMonitor(window.window, monitor.monitor, xPos, yPos, width, height, refreshRate)

@GLFW
actual inline fun glfwGetWindowAttrib(window: GLFWWindow?, attrib: Int): Int =
	glfw.glfwGetWindowAttrib(window.window, attrib)

@GLFW
actual inline fun glfwSetWindowAttrib(window: GLFWWindow?, attrib: Int, value: Int) =
	glfw.glfwSetWindowAttrib(window.window, attrib, value)

@GLFW
actual inline fun glfwSetWindowUserPointer(window: GLFWWindow?, pointer: Ptr<*>?) =
	glfw.glfwSetWindowUserPointer(window.window, pointer)

@GLFW
actual inline fun glfwGetWindowUserPointer(window: GLFWWindow?): Ptr<*>? = glfw.glfwGetWindowUserPointer(window.window)

//

@GLFW
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFW
actual inline fun glfwWaitEvents() = glfw.glfwWaitEvents()

@GLFW
actual inline fun glfwWaitEventsTimeout(timeout: Double) = glfw.glfwWaitEventsTimeout(timeout)

@GLFW
actual inline fun glfwPostEmptyEvent() = glfw.glfwPostEmptyEvent()

@GLFW
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)