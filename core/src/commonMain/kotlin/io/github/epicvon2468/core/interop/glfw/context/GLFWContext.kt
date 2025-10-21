package io.github.epicvon2468.core.interop.glfw.context

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.window.GLFWWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwSwapBuffers

// https://www.glfw.org/docs/3.4/group__context.html

@GLFW
interface GLFWGLProc

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
@GLFW
expect fun glfwMakeContextCurrent(window: GLFWWindow?)

@GLFW
expect fun glfwGetCurrentContext(): GLFWWindow?

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
@GLFW
expect fun glfwSwapInterval(interval: Int)

@GLFW
expect fun glfwExtensionSupported(extension: String?): Boolean

// GLFWGLProc glfwGetProcAddress(const char *procname)