package io.github.epicvon2468.core.interop

@DslMarker
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPEALIAS, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
annotation class GLFWWrapper

/**
 * This function initialises the GLFW library. Before most GLFW functions can
 * be used, GLFW must be initialised, and before an application terminates GLFW
 * should be terminated in order to free any resources allocated during or
 * after initialisation.
 *
 * If this function fails, it calls [glfwTerminate] before returning. If it
 * succeeds, you should call [glfwTerminate] before the application exits.
 *
 * Additional calls to this function after successful initialisation but before
 * termination will return `true` immediately.
 *
 * The [GLFW_PLATFORM] init hint controls which platforms are considered during
 * initialisation. This also depends on which platforms the library was compiled to
 * support.
 *
 * **macOS:** This function will change the current directory of the
 * application to the `Contents/Resources` subdirectory of the application's
 * bundle, if present. This can be disabled with the [GLFW_COCOA_CHDIR_RESOURCES] init hint.
 *
 * **macOS:** This function will create the main menu and dock icon for the
 * application. If GLFW finds a `MainMenu.nib` it is loaded and assumed to
 * contain a menu bar. Otherwise, a minimal menu bar is created manually with
 * common commands like 'Hide', 'Quit' and 'About'. The 'About' entry opens a minimal
 * about dialog with information from the application's bundle. The menu bar
 * and dock icon can be disabled entirely with the [GLFW_COCOA_MENUBAR] init
 * hint.
 *
 * **Wayland, X11:** If the library was compiled with support for both
 * Wayland and X11, and the [GLFW_PLATFORM] init hint is set to
 * `GLFW_ANY_PLATFORM`, the `XDG_SESSION_TYPE` environment variable affects
 * which platform is picked. If the environment variable is not set, or is set
 * to something other than `wayland` or `x11`, the regular detection mechanism
 * will be used instead.
 *
 * **X11:** This function will set the `LC_CTYPE` category of the
 * application locale according to the current environment if that category is
 * still "C". This is because the "C" locale breaks Unicode text input.
 *
 * **Thread Safety:** This function must only be called from the main thread.
 *
 * @see intro_init
 * @see glfwInitHint
 * @see glfwInitAllocator
 * @see glfwTerminate
 *
 * @since Added in version 1.0.
 *
 * @return `true` if successful, or `false` if an error occurred.
 */
@GLFWWrapper
expect fun glfwInit(): Boolean

/**
 * This function destroys all remaining windows and cursors, restores any
 * modified gamma ramps and frees any other allocated resources. Once this
 * function is called, you must again call [glfwInit] successfully before
 * you will be able to use most GLFW functions.
 *
 * If GLFW has been successfully initialised, this function should be called
 * before the application exits. If initialisation fails, there is no need to
 * call this function, as it is called by [glfwInit] before it returns
 * failure.
 *
 * This function has no effect if GLFW is not initialised.
 *
 * **Errors:** Possible errors include [GLFW_PLATFORM_ERROR].
 *
 * This function may be called before [glfwInit].
 *
 * **Warning:** The contexts of any remaining windows must not be current on any
 * other thread when this function is called.
 *
 * **Reentrancy:** This function must not be called from a callback.
 *
 * **Thread Safety:** This function must only be called from the main thread.
 *
 * @see intro_init
 * @see glfwInit
 *
 * @since Added in version 1.0.
 */
@GLFWWrapper
expect fun glfwTerminate()

/**
 * This function sets the swap interval for the current OpenGL or OpenGL ES
 * context, i.e. the number of screen updates to wait from the time
 * [glfwSwapBuffers] was called before swapping the buffers and returning. This
 * is sometimes called _vertical synchronisation_, _vertical retrace
 * synchronisation_ or just _vsync_.
 *
 * A context that supports either of the `WGL_EXT_swap_control_tear` and
 * `GLX_EXT_swap_control_tear` extensions also accepts _negative_ swap
 * intervals, which allows the driver to swap immediately even if a frame
 * arrives a little bit late. You can check for these extensions with [glfwExtensionSupported].
 *
 * A context must be current on the calling thread. Calling this function
 * without a current context will cause a [GLFW_NO_CURRENT_CONTEXT] error.
 *
 * This function does not apply to Vulkan. If you are rendering with Vulkan,
 * see the present mode of your swapchain instead.
 *
 * This function is not called during context creation, leaving the
 * swap interval set to whatever is the default for that API. This is done
 * because some swap interval extensions used by GLFW do not allow the swap
 * interval to be reset to zero once it has been set to a non-zero value.
 *
 * Some GPU drivers do not honor the requested swap interval, either
 * because of a user setting that overrides the application's request or due to
 * bugs in the driver.
 *
 * **Errors:** Possible errors include [GLFW_NOT_INITIALISED],
 * [GLFW_NO_CURRENT_CONTEXT] and [GLFW_PLATFORM_ERROR].
 *
 * **Thread Safety:** This function may be called from any thread.
 *
 * @param interval The minimum number of screen updates to wait for
 * until the buffers are swapped by [glfwSwapBuffers].
 *
 * @see buffer_swap
 * @see glfwSwapBuffers
 *
 * @since Added in version 1.0.
 */
@GLFWWrapper
expect fun glfwSwapInterval(interval: Int)

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
@GLFWWrapper
typealias GLFWErrorFun = (error: Int, description: String?) -> Unit

/**
 * This function sets the error callback, which is called with an error code
 * and a human-readable description each time a GLFW error occurs.
 *
 * The error code is set before the callback is called. Calling [glfwGetError]
 * from the error callback will return the same value as the error
 * code argument.
 *
 * The error callback is called on the thread where the error occurred. If you
 * are using GLFW from multiple threads, your error callback needs to be
 * written accordingly.
 *
 * Because the description string may have been generated specifically for that
 * error, it is not guaranteed to be valid after the callback has returned. If
 * you wish to use it after the callback returns, you need to make a copy.
 *
 * Once set, the error callback remains set even after the library has been
 * terminated.
 *
 * **Callback Signature:**
 * ```
 * fun callbackName(error: Int, description: String?): Unit
 * ```
 * For more information about the callback parameters, see the [callback pointer type][GLFWerrorfun].
 *
 * This function may be called before [glfwInit].
 *
 * **Thread Safety:** This function must only be called from the main thread.
 *
 * @param callback The new callback, or `null` to remove the currently set
 * callback.
 *
 * @see error_handling
 * @see glfwGetError
 *
 * @since Added in version 3.0.
 *
 * @return The previously set callback, or `null` if no callback was set.
 * KMP_GE Note: Due to difficulties with C Strings, Unit is returned instead.
 */
@GLFWWrapper
expect fun glfwSetErrorCallback(callback: GLFWErrorFun?)

/**
 * Opaque window object.
 *
 * @see window_object
 *
 * @since Added in version 3.0.
 */
@GLFWWrapper
interface GLFWWindow

/**
 * Opaque monitor object.
 *
 * @see monitor_object
 *
 * @since Added in version 3.0.
 */
@GLFWWrapper
interface GLFWMonitor

/**
 * This function makes the OpenGL or OpenGL ES context of the specified window
 * current on the calling thread. It can also detach the current context from
 * the calling thread without making a new one current by passing in `null`.
 *
 * A context must only be made current on a single thread at a time and each
 * thread can have only a single current context at a time. Making a context
 * current detaches any previously current context on the calling thread.
 *
 * When moving a context between threads, you must detach it (make it
 * non-current) on the old thread before making it current on the new one.
 *
 * By default, making a context non-current implicitly forces a pipeline flush.
 * On machines that support `GL_KHR_context_flush_control`, you can control
 * whether a context performs this flush by setting the
 * [GLFW_CONTEXT_RELEASE_BEHAVIOR][GLFW_CONTEXT_RELEASE_BEHAVIOR_hint]
 * hint.
 *
 * The specified window must have an OpenGL or OpenGL ES context. Specifying
 * a window without a context will generate a [GLFW_NO_WINDOW_CONTEXT]
 * error.
 *
 * If the previously current context was created via a different
 * context creation API than the one passed to this function, GLFW will still
 * detach the previous one from its API before making the new one current.
 *
 * **Errors:** Possible errors include [GLFW_NOT_INITIALISED], [GLFW_NO_WINDOW_CONTEXT] and [GLFW_PLATFORM_ERROR].
 *
 * **Thread Safety:** This function may be called from any thread.
 *
 * @param window The window whose context to make current, or `null` to
 * detach the current context.
 *
 * @see context_current
 * @see glfwGetCurrentContext
 *
 * @since Added in version 3.0.
 */
@GLFWWrapper
expect fun glfwMakeContextCurrent(window: GLFWWindow?)

@GLFWWrapper
expect fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor? = null,
	share: GLFWWindow? = null
): GLFWWindow?

@GLFWWrapper
expect fun glfwDestroyWindow(window: GLFWWindow?)