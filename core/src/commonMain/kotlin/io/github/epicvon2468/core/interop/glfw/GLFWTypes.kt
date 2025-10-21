package io.github.epicvon2468.core.interop.glfw

/**
 * Opaque window object.
 *
 * @see window_object
 *
 * @since Added in version 3.0.
 */
@GLFW
interface GLFWWindow

/**
 * Opaque monitor object.
 *
 * @see monitor_object
 *
 * @since Added in version 3.0.
 */
@GLFW
interface GLFWMonitor

/**
 * This is the function pointer type for error callbacks. An error callback
 * function has the following signature:
 * ```
 * fun callbackName(error: Int, description: String?): Unit
 * ```
 *
 * **Pointer Lifetime:** The error description string is valid until the callback
 * function returns.
 *
 * @param error An error code. Future releases may add more error codes.
 * @param description A UTF-8 encoded string describing the error.
 *
 * @see error_handling
 * @see glfwSetErrorCallback
 *
 * @since Added in version 3.0.
 */
@GLFW
typealias GLFWErrorFun = (error: Int, description: String?) -> Unit