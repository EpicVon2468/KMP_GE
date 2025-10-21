package io.github.epicvon2468.core.interop.glfw

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
@GLFW
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
@GLFW
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
@GLFW
expect fun glfwSwapInterval(interval: Int)

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
@GLFW
expect fun glfwSetErrorCallback(callback: GLFWErrorFun?)

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

/**
 * This function creates a window and its associated OpenGL or OpenGL ES
 * context. Most of the options controlling how the window and its context
 * should be created are specified with [window hints][window_hints].
 *
 * Successful creation does not change which context is current. Before you
 * can use the newly created context, you need to [make it current][context_current].
 * For information about the `share` parameter, see [context_sharing].
 *
 * The created window, framebuffer and context may differ from what you
 * requested, as not all parameters and hints are [hard constraints][window_hints_hard].
 * This includes the size of the window, especially for full screen windows.
 * To query the actual attributes of the created window, framebuffer and context, see
 * [glfwGetWindowAttrib], [glfwGetWindowSize] and [glfwGetFramebufferSize].
 *
 * To create a full screen window, you need to specify the monitor the window
 * will cover. If no monitor is specified, the window will be windowed mode.
 * Unless you have a way for the user to choose a specific monitor, it is
 * recommended that you pick the primary monitor. For more information on how
 * to query connected monitors, see [monitor_monitors].
 *
 * For full screen windows, the specified size becomes the resolution of the
 * window's _desired video mode_.  As long as a full screen window is not
 * iconified, the supported video mode most closely matching the desired video
 * mode is set for the specified monitor.  For more information about full
 * screen windows, including the creation of so called _windowed full screen_
 * or _borderless full screen_ windows, see [window_windowed_full_screen].
 *
 * Once you have created the window, you can switch it between windowed and
 * full screen mode with [glfwSetWindowMonitor]. This will not affect its
 * OpenGL or OpenGL ES context.
 *
 * By default, newly created windows use the placement recommended by the
 * window system.  To create the window at a specific position, set the [GLFW_POSITION_X]
 * and [GLFW_POSITION_Y] window hints before creation. To restore the default behavior,
 * set either or both hints back to `GLFW_ANY_POSITION`.
 *
 * As long as at least one full screen window is not iconified, the screensaver
 * is prohibited from starting.
 *
 * Window systems put limits on window sizes. Very large or very small window
 * dimensions may be overridden by the window system on creation. Check the
 * actual [size][window_size] after creation.
 *
 * The [swap interval][buffer_swap] is not set during window creation and
 * the initial value may vary depending on driver settings and defaults.
 *
 * **Errors:** Possible errors include [GLFW_NOT_INITIALISED], [GLFW_INVALID_ENUM],
 * [GLFW_INVALID_VALUE], [GLFW_API_UNAVAILABLE], [GLFW_VERSION_UNAVAILABLE],
 * [GLFW_FORMAT_UNAVAILABLE], [GLFW_NO_WINDOW_CONTEXT] and [GLFW_PLATFORM_ERROR].
 *
 * **Win32:** Window creation will fail if the Microsoft GDI software
 * OpenGL implementation is the only one available.
 *
 * **Win32:** If the executable has an icon resource named `GLFW_ICON`, it
 * will be set as the initial icon for the window. If no such icon is present,
 * the `IDI_APPLICATION` icon will be used instead. To set a different icon,
 * see [glfwSetWindowIcon].
 *
 * **Win32:** The context to share resources with must not be current on any other thread.
 *
 * **macOS:** The OS only supports core profile contexts for OpenGL
 * versions 3.2 and later. Before creating an OpenGL context of version 3.2 or
 * later you must set the [GLFW_OPENGL_PROFILE][GLFW_OPENGL_PROFILE_hint] hint accordingly.
 * OpenGL 3.0 and 3.1 contexts are not supported at all on macOS.
 *
 * **macOS:** The GLFW window has no icon, as it is not a document
 * window, but the dock icon will be the same as the application bundle's icon.
 * For more information on bundles, see the
 * [Bundle Programming Guide](https://developer.apple.com/library/mac/documentation/CoreFoundation/Conceptual/CFBundles/)
 * in the Mac Developer Library.
 *
 * **macOS:** On OS X 10.10 and later the window frame will not be rendered
 * at full resolution on Retina displays unless the [GLFW_SCALE_FRAMEBUFFER][GLFW_SCALE_FRAMEBUFFER_hint]
 * hint is `GLFW_TRUE` and the `NSHighResolutionCapable` key is enabled in the
 * application bundle's `Info.plist`. For more information, see
 * [High Resolution Guidelines for OS X](https://developer.apple.com/library/mac/documentation/GraphicsAnimation/Conceptual/HighResolutionOSX/Explained/Explained.html)
 * in the Mac Developer Library. The GLFW test and example programs use a custom `Info.plist`
 * template for this, which can be found as `CMake/Info.plist.in` in the source tree.
 *
 * **macOS:** When activating frame autosaving with [GLFW_COCOA_FRAME_NAME][GLFW_COCOA_FRAME_NAME_hint],
 * the specified window size and position may be overridden by previously saved values.
 *
 * **Wayland:** GLFW uses [libdecor](https://gitlab.freedesktop.org/libdecor/libdecor)
 * where available to create its window decorations. This in turn uses server-side XDG
 * decorations where available and provides high quality client-side decorations on
 * compositors like GNOME. If both XDG decorations and libdecor are unavailable, GLFW
 * falls back to a very simple set of window decorations that only support moving,
 * resizing and the window manager's right-click menu.
 *
 * **X11:** Some window managers will not respect the placement of initially hidden windows.
 *
 * **X11:** Due to the asynchronous nature of X11, it may take a moment for
 * a window to reach its requested state. This means you may not be able to
 * query the final size, position or other attributes directly after window
 * creation.
 *
 * **X11:** The class part of the `WM_CLASS` window property will by
 * default be set to the window title passed to this function. The instance
 * part will use the contents of the `RESOURCE_NAME` environment variable, if
 * present and not empty, or fall back to the window title. Set the
 * [GLFW_X11_CLASS_NAME][GLFW_X11_CLASS_NAME_hint] and
 * [GLFW_X11_INSTANCE_NAME][GLFW_X11_INSTANCE_NAME_hint] window hints to
 * override this.
 *
 * **Thread Safety:** This function must only be called from the main thread.
 *
 * @param width The desired width, in screen coordinates, of the window. This must be greater than zero.
 * @param height The desired height, in screen coordinates, of the window.
 * This must be greater than zero.
 * @param title The initial, UTF-8 encoded window title.
 * @param monitor The monitor to use for full screen mode, or `null` for
 * windowed mode.
 * @param share The window whose context to share resources with, or `null`
 * to not share resources.
 * @return The handle of the created window, or `null` if an  [error][error_handling] occurred.
 *
 * @see window_creation
 * @see glfwDestroyWindow
 *
 * @since Added in version 3.0.  Replaces `glfwOpenWindow`.
 */
@GLFW
expect fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor? = null,
	share: GLFWWindow? = null
): GLFWWindow?

/**
 * This function destroys the specified window and its context. On calling
 * this function, no further callbacks will be called for that window.
 *
 * If the context of the specified window is current on the main thread, it is
 * detached before being destroyed.
 *
 * **Errors:** Possible errors include [GLFW_NOT_INITIALISED] and [GLFW_PLATFORM_ERROR].
 *
 * **Note:** The context of the specified window must not be current on any other
 * thread when this function is called.
 *
 * **Reentrancy:** This function must not be called from a callback.
 *
 * **Thread Safety:** This function must only be called from the main thread.
 *
 * @param window The window to destroy.
 *
 * @see window_creation
 * @see glfwCreateWindow
 *
 * @since Added in version 3.0.  Replaces `glfwCloseWindow`.
 */
@GLFW
expect fun glfwDestroyWindow(window: GLFWWindow?)

@GLFW
expect fun glfwPollEvents()

@GLFW
expect fun glfwSwapBuffers(window: GLFWWindow?)

@GLFW
expect fun glfwWindowShouldClose(window: GLFWWindow?): Boolean

@GLFW
@Suppress("NOTHING_TO_INLINE")
inline fun Int.glfwBoolean(): Boolean = when (this) {
	GLFW_TRUE -> true
	GLFW_FALSE -> false
	else -> error("Couldn't parse glfw boolean '$this', expected either '${GLFW_TRUE}' (true) or '${GLFW_FALSE}' (false)!")
}