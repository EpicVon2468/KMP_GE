package io.github.epicvon2468.core.interop

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
expect fun glfwTerminate()

expect fun glfwSwapInterval(interval: Int)