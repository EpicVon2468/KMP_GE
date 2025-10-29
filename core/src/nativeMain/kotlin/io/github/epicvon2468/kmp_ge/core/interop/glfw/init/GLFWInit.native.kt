@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE", "FunctionName", "ObjectPropertyName")
package io.github.epicvon2468.kmp_ge.core.interop.glfw.init

import io.github.epicvon2468.kmp_ge.core.interop.glfw.GLFW
import io.github.epicvon2468.kmp_ge.core.interop.glfw.glfwBoolean

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

@GLFW
actual const val GLFW_VERSION_MAJOR: Int = glfw.GLFW_VERSION_MAJOR

@GLFW
actual const val GLFW_VERSION_MINOR: Int = glfw.GLFW_VERSION_MINOR

@GLFW
actual const val GLFW_TRUE: Int = glfw.GLFW_TRUE

@GLFW
actual const val GLFW_FALSE: Int = glfw.GLFW_FALSE

@GLFW
actual const val GLFW_JOYSTICK_HAT_BUTTONS: Int = glfw.GLFW_JOYSTICK_HAT_BUTTONS

@GLFW
actual const val GLFW_ANGLE_PLATFORM_TYPE: Int = glfw.GLFW_ANGLE_PLATFORM_TYPE

@GLFW
actual const val GLFW_PLATFORM: Int = glfw.GLFW_PLATFORM

@GLFW
actual const val GLFW_COCOA_CHDIR_RESOURCE: Int = glfw.GLFW_COCOA_CHDIR_RESOURCES

@GLFW
actual const val GLFW_COCOA_MENUBAR: Int = glfw.GLFW_COCOA_MENUBAR

@GLFW
actual const val GLFW_X11_XCB_VULKAN_SURFACE: Int = glfw.GLFW_X11_XCB_VULKAN_SURFACE

@GLFW
actual const val GLFW_WAYLAND_LIBDECOR: Int = glfw.GLFW_WAYLAND_LIBDECOR

@GLFW
actual const val GLFW_ANY_PLATFORM: Int = glfw.GLFW_ANY_PLATFORM

@GLFW
actual const val GLFW_PLATFORM_WIN32: Int = glfw.GLFW_PLATFORM_WIN32

@GLFW
actual const val GLFW_PLATFORM_COCOA: Int = glfw.GLFW_PLATFORM_COCOA

@GLFW
actual const val GLFW_PLATFORM_WAYLAND: Int = glfw.GLFW_PLATFORM_WAYLAND

@GLFW
actual const val GLFW_PLATFORM_X11: Int = glfw.GLFW_PLATFORM_X11

@GLFW
actual const val GLFW_PLATFORM_NULL: Int = glfw.GLFW_PLATFORM_NULL

@GLFW
actual inline fun glfwInit(): Boolean = glfw.glfwInit().glfwBoolean()

@GLFW
actual inline fun glfwTerminate() = glfw.glfwTerminate()

@GLFW
actual inline fun glfwInitHint(hint: Int, value: Int) = glfw.glfwInitHint(hint, value)

@GLFW
actual inline fun glfwGetVersionString(): String = glfw.glfwGetVersionString()?.toKString()
	?: error("Native `glfwGetVersionString()` call returned null! This is impossible as it should be a compile-time constant!")

var _callback: GLFWErrorFun? = null

fun __callback(error: Int, description: CPointer<ByteVar>?) {
	_callback?.invoke(error, description?.toKString())
}

@GLFW
actual inline fun glfwSetErrorCallback(noinline callback: GLFWErrorFun?) {
	// FIXME: Can't return the old callback because `String.cstr` is `CValues<ByteVar>` and not `CPointer<ByteVar>`
	// Annoyingly, staticCFunction doesn't let you reference variables, but it allows this... and it works.
	// If there's a more efficient or better way to do this in future, I'll change to use that instead.
	if (callback == null) {
		glfw.glfwSetErrorCallback(null)
		_callback = null
		return
	}
	_callback = callback
	glfw.glfwSetErrorCallback(staticCFunction(::__callback))
}

@GLFW
actual inline fun glfwGetPlatform(): Int = glfw.glfwGetPlatform()

@GLFW
actual inline fun glfwPlatformSupported(platform: Int): Boolean = glfw.glfwPlatformSupported(platform).glfwBoolean()