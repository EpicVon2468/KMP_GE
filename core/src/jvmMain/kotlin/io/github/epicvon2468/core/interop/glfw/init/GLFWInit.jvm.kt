package io.github.epicvon2468.core.interop.glfw.init

import io.github.epicvon2468.core.interop.glfw.GLFW

@GLFW
actual val GLFW_VERSION_MAJOR: Int get() = TODO()

@GLFW
actual val GLFW_VERSION_MINOR: Int get() = TODO()

@GLFW
actual val GLFW_TRUE: Int get() = TODO()

@GLFW
actual val GLFW_FALSE: Int get() = TODO()

@GLFW
actual val GLFW_JOYSTICK_HAT_BUTTONS: Int get() = TODO()

@GLFW
actual val GLFW_ANGLE_PLATFORM_TYPE: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM: Int get() = TODO()

@GLFW
actual val GLFW_COCOA_CHDIR_RESOURCE: Int get() = TODO()

@GLFW
actual val GLFW_COCOA_MENUBAR: Int get() = TODO()

@GLFW
actual val GLFW_X11_XCB_VULKAN_SURFACE: Int get() = TODO()

@GLFW
actual val GLFW_WAYLAND_LIBDECOR: Int get() = TODO()

@GLFW
actual val GLFW_ANY_PLATFORM: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM_WIN32: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM_COCOA: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM_WAYLAND: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM_X11: Int get() = TODO()

@GLFW
actual val GLFW_PLATFORM_NULL: Int get() = TODO()

@GLFW
actual fun glfwInit(): Boolean = TODO()

@GLFW
actual fun glfwTerminate(): Unit = TODO()

@GLFW
actual fun glfwInitHint(hint: Int, value: Int): Unit = TODO()

@GLFW
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?): Unit = TODO()

@GLFW
actual fun glfwGetVersionString(): String = TODO()

@GLFW
actual fun glfwGetPlatform(): Int = TODO()

@GLFW
actual fun glfwPlatformSupported(platform: Int): Boolean = TODO()