package io.github.epicvon2468.core.interop.glfw.window

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.Ptr
import io.github.epicvon2468.core.interop.glfw.monitor.GLFWMonitor

@GLFW
actual val GLFW_FOCUSED: Int get() = TODO()

@GLFW
actual val GLFW_ICONIFIED: Int get() = TODO()

@GLFW
actual val GLFW_RESIZABLE: Int get() = TODO()

@GLFW
actual val GLFW_VISIBLE: Int get() = TODO()

@GLFW
actual val GLFW_DECORATED: Int get() = TODO()

@GLFW
actual val GLFW_AUTO_ICONIFY: Int get() = TODO()

@GLFW
actual val GLFW_FLOATING: Int get() = TODO()

@GLFW
actual val GLFW_MAXIMISED: Int get() = TODO()

@GLFW
actual val GLFW_CENTRE_CURSOR: Int get() = TODO()

@GLFW
actual val GLFW_TRANSPARENT_FRAMEBUFFER: Int get() = TODO()

@GLFW
actual val GLFW_HOVERED: Int get() = TODO()

@GLFW
actual val GLFW_FOCUS_ON_SHOW: Int get() = TODO()

@GLFW
actual val GLFW_MOUSE_PASSTHROUGH: Int get() = TODO()

@GLFW
actual val GLFW_POSITION_X: Int get() = TODO()

@GLFW
actual val GLFW_POSITION_Y: Int get() = TODO()

@GLFW
actual val GLFW_RED_BITS: Int get() = TODO()

@GLFW
actual val GLFW_GREEN_BITS: Int get() = TODO()

@GLFW
actual val GLFW_BLUE_BITS: Int get() = TODO()

@GLFW
actual val GLFW_ALPHA_BITS: Int get() = TODO()

@GLFW
actual val GLFW_DEPTH_BITS: Int get() = TODO()

@GLFW
actual val GLFW_STENCIL_BITS: Int get() = TODO()

@GLFW
actual val GLFW_ACCUM_RED_BITS: Int get() = TODO()

@GLFW
actual val GLFW_ACCUM_GREEN_BITS: Int get() = TODO()

@GLFW
actual val GLFW_ACCUM_BLUE_BITS: Int get() = TODO()

@GLFW
actual val GLFW_ACCUM_ALPHA_BITS: Int get() = TODO()

@GLFW
actual val GLFW_AUX_BUFFERS: Int get() = TODO()

@GLFW
actual val GLFW_STEREO: Int get() = TODO()

@GLFW
actual val GLFW_SAMPLES: Int get() = TODO()

@GLFW
actual val GLFW_SRGB_CAPABLE: Int get() = TODO()

@GLFW
actual val GLFW_REFRESH_RATE: Int get() = TODO()

@GLFW
actual val GLFW_DOUBLEBUFFER: Int get() = TODO()

@GLFW
actual val GLFW_CLIENT_API: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_VERSION_MAJOR: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_VERSION_MINOR: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_REVISION: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_ROBUSTNESS: Int get() = TODO()

@GLFW
actual val GLFW_OPENGL_FORWARD_COMPAT: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_DEBUG: Int get() = TODO()

@GLFW
actual val GLFW_OPENGL_DEBUG_CONTEXT: Int get() = TODO()

@GLFW
actual val GLFW_OPENGL_PROFILE: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_RELEASE_BEHAVIOUR: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_NO_ERROR: Int get() = TODO()

@GLFW
actual val GLFW_CONTEXT_CREATION_API: Int get() = TODO()

@GLFW
actual val GLFW_SCALE_TO_MONITOR: Int get() = TODO()

@GLFW
actual val GLFW_SCALE_FRAMEBUFFER: Int get() = TODO()

@GLFW
actual val GLFW_COCOA_RETINA_FRAMEBUFFER: Int get() = TODO()

@GLFW
actual val GLFW_COCOA_FRAME_NAME: Int get() = TODO()

@GLFW
actual val GLFW_COCOA_GRAPHICS_SWITCHING: Int get() = TODO()

@GLFW
actual val GLFW_X11_CLASS_NAME: Int get() = TODO()

@GLFW
actual val GLFW_X11_INSTANCE_NAME: Int get() = TODO()

@GLFW
actual val GLFW_WIN32_KEYBOARD_MENU: Int get() = TODO()

@GLFW
actual val GLFW_WIN32_SHOWDEFAULT: Int get() = TODO()

@GLFW
actual val GLFW_WAYLAND_APP_ID: Int get() = TODO()

@GLFW
actual fun glfwDefaultWindowHints(): Unit = TODO()

@GLFW
actual fun glfwWindowHint(hint: Int, value: Int): Unit = TODO()

@GLFW
actual fun glfwWindowHintString(hint: Int, value: String?): Unit = TODO()

@GLFW
actual fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?/* = null*/,
	share: GLFWWindow?/* = null*/
): GLFWWindow? = TODO()

@GLFW
actual fun glfwDestroyWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwWindowShouldClose(window: GLFWWindow?): Boolean = TODO()

@GLFW
actual fun glfwGetWindowTitle(window: GLFWWindow?): String? = TODO()

@GLFW
actual fun glfwSetWindowTitle(window: GLFWWindow?, title: String?): Unit = TODO()

@GLFW
actual fun glfwSetWindowIcon(window: GLFWWindow?, count: Int, images: GLFWImage?): Unit = TODO()

@GLFW
actual fun glfwSetWindowPos(window: GLFWWindow?, xPos: Int, yPos: Int): Unit = TODO()

@GLFW
actual fun glfwSetWindowSizeLimits(
	window: GLFWWindow?,
	minWidth: Int,
	minHeight: Int,
	maxWidth: Int,
	maxHeight: Int
): Unit = TODO()

@GLFW
actual fun glfwSetWindowAspectRatio(window: GLFWWindow?, numer: Int, demon: Int): Unit = TODO()

@GLFW
actual fun glfwSetWindowSize(window: GLFWWindow?, width: Int, height: Int): Unit = TODO()

@GLFW
actual fun glfwGetWindowOpacity(window: GLFWWindow?): Float = TODO()

@GLFW
actual fun glfwSetWindowOpacity(window: GLFWWindow?, opacity: Float): Unit = TODO()

@GLFW
actual fun glfwIconifyWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwRestoreWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwMaximiseWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwShowWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwHideWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwFocusWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwRequestWindowAttention(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwGetWindowMonitor(window: GLFWWindow?): GLFWMonitor? = TODO()

@GLFW
actual fun glfwSetWindowMonitor(
	window: GLFWWindow?,
	monitor: GLFWMonitor?,
	xPos: Int,
	yPos: Int,
	width: Int,
	height: Int,
	refreshRate: Int
): Unit = TODO()

@GLFW
actual fun glfwGetWindowAttrib(window: GLFWWindow?, attrib: Int): Int = TODO()

@GLFW
actual fun glfwSetWindowAttrib(window: GLFWWindow?, attrib: Int, value: Int): Unit = TODO()

@GLFW
actual fun glfwSetWindowUserPointer(window: GLFWWindow?, pointer: Ptr<*>?): Unit = TODO()

@GLFW
actual fun glfwGetWindowUserPointer(window: GLFWWindow?): Ptr<*>? = TODO()

//

@GLFW
actual fun glfwPollEvents(): Unit = TODO()

@GLFW
actual fun glfwWaitEvents(): Unit = TODO()

@GLFW
actual fun glfwWaitEventsTimeout(timeout: Double): Unit = TODO()

@GLFW
actual fun glfwPostEmptyEvent(): Unit = TODO()

@GLFW
actual fun glfwSwapBuffers(window: GLFWWindow?): Unit = TODO()