package io.github.epicvon2468.kmp_ge.core.interop.glfw.window

import io.github.epicvon2468.kmp_ge.core.interop.IntVar
import io.github.epicvon2468.kmp_ge.core.interop.glfw.GLFW
import io.github.epicvon2468.kmp_ge.core.interop.Ptr
import io.github.epicvon2468.kmp_ge.core.interop.glfw.monitor.GLFWMonitor

// https://www.glfw.org/docs/3.4/group__window.html

@GLFW
expect val GLFW_FOCUSED: Int

@GLFW
expect val GLFW_ICONIFIED: Int

@GLFW
expect val GLFW_RESIZABLE: Int

@GLFW
expect val GLFW_VISIBLE: Int

@GLFW
expect val GLFW_DECORATED: Int

@GLFW
expect val GLFW_AUTO_ICONIFY: Int

@GLFW
expect val GLFW_FLOATING: Int

@GLFW
expect val GLFW_MAXIMISED: Int

@GLFW
expect val GLFW_CENTRE_CURSOR: Int

@GLFW
expect val GLFW_TRANSPARENT_FRAMEBUFFER: Int

@GLFW
expect val GLFW_HOVERED: Int

@GLFW
expect val GLFW_FOCUS_ON_SHOW: Int

@GLFW
expect val GLFW_MOUSE_PASSTHROUGH: Int

@GLFW
expect val GLFW_POSITION_X: Int

@GLFW
expect val GLFW_POSITION_Y: Int

@GLFW
expect val GLFW_RED_BITS: Int

@GLFW
expect val GLFW_GREEN_BITS: Int

@GLFW
expect val GLFW_BLUE_BITS: Int

@GLFW
expect val GLFW_ALPHA_BITS: Int

@GLFW
expect val GLFW_DEPTH_BITS: Int

@GLFW
expect val GLFW_STENCIL_BITS: Int

@GLFW
expect val GLFW_ACCUM_RED_BITS: Int

@GLFW
expect val GLFW_ACCUM_GREEN_BITS: Int

@GLFW
expect val GLFW_ACCUM_BLUE_BITS: Int

@GLFW
expect val GLFW_ACCUM_ALPHA_BITS: Int

@GLFW
expect val GLFW_AUX_BUFFERS: Int

@GLFW
expect val GLFW_STEREO: Int

@GLFW
expect val GLFW_SAMPLES: Int

@GLFW
expect val GLFW_SRGB_CAPABLE: Int

@GLFW
expect val GLFW_REFRESH_RATE: Int

@GLFW
expect val GLFW_DOUBLEBUFFER: Int

@GLFW
expect val GLFW_CLIENT_API: Int

@GLFW
expect val GLFW_CONTEXT_VERSION_MAJOR: Int

@GLFW
expect val GLFW_CONTEXT_VERSION_MINOR: Int

@GLFW
expect val GLFW_CONTEXT_REVISION: Int

@GLFW
expect val GLFW_CONTEXT_ROBUSTNESS: Int

@GLFW
expect val GLFW_OPENGL_FORWARD_COMPAT: Int

@GLFW
expect val GLFW_CONTEXT_DEBUG: Int

@GLFW
expect val GLFW_OPENGL_DEBUG_CONTEXT: Int

@GLFW
expect val GLFW_OPENGL_PROFILE: Int

@GLFW
expect val GLFW_CONTEXT_RELEASE_BEHAVIOUR: Int

@GLFW
expect val GLFW_CONTEXT_NO_ERROR: Int

@GLFW
expect val GLFW_CONTEXT_CREATION_API: Int

@GLFW
expect val GLFW_SCALE_TO_MONITOR: Int

@GLFW
expect val GLFW_SCALE_FRAMEBUFFER: Int

@GLFW
expect val GLFW_COCOA_RETINA_FRAMEBUFFER: Int

@GLFW
expect val GLFW_COCOA_FRAME_NAME: Int

@GLFW
expect val GLFW_COCOA_GRAPHICS_SWITCHING: Int

@GLFW
expect val GLFW_X11_CLASS_NAME: Int

@GLFW
expect val GLFW_X11_INSTANCE_NAME: Int

@GLFW
expect val GLFW_WIN32_KEYBOARD_MENU: Int

@GLFW
expect val GLFW_WIN32_SHOWDEFAULT: Int

@GLFW
expect val GLFW_WAYLAND_APP_ID: Int

/**
 * Opaque window object.
 *
 * @see window_object
 *
 * @since Added in version 3.0.
 */
@GLFW
interface GLFWWindow

@GLFW
interface GLFWImage

@GLFW
typealias GLFWFramebufferSizeFun = (window: GLFWWindow?, width: Int, height: Int) -> Unit

@GLFW
expect fun glfwDefaultWindowHints()

@GLFW
expect fun glfwWindowHint(hint: Int, value: Int)

@GLFW
expect fun glfwWindowHintString(hint: Int, value: String?)

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
expect fun glfwWindowShouldClose(window: GLFWWindow?): Boolean

@GLFW
expect fun glfwSetWindowShouldClose(window: GLFWWindow?, value: Boolean)

@GLFW
expect fun glfwGetWindowTitle(window: GLFWWindow?): String?

@GLFW
expect fun glfwSetWindowTitle(window: GLFWWindow?, title: String?)

@GLFW
expect fun glfwSetWindowIcon(window: GLFWWindow?, count: Int, images: GLFWImage?)

// void glfwGetWindowPos(GLFWWindow *window, int *xPos, int *yPos)

@GLFW
expect fun glfwSetWindowPos(window: GLFWWindow?, xPos: Int, yPos: Int)

// void glfwGetWindowSize(GLFWWindow *window, int *width, int *height)

@GLFW
expect fun glfwSetWindowSizeLimits(
	window: GLFWWindow?,
	minWidth: Int,
	minHeight: Int,
	maxWidth: Int,
	maxHeight: Int
)

@GLFW
expect fun glfwSetWindowAspectRatio(window: GLFWWindow?, numer: Int, demon: Int)

@GLFW
expect fun glfwSetWindowSize(window: GLFWWindow?, width: Int, height: Int)

// void glfwGetFramebufferSize(GLFWWindow *window, int *left, int *top)

// void glfwGetWindowFrameSize(GLFWWindow *window, int *left, int *top, int *right, int *bottom)

// TODO: Widen access from `Ptr<IntVar>` to `CValuesRef<IntVar>`
@GLFW
expect fun glfwGetFramebufferSize(window: GLFWWindow?, left: Ptr<IntVar>, top: Ptr<IntVar>)

// void glfwGetWindowContentScale(GLFWWindow *window, float *xScale, float *yScale)

@GLFW
expect fun glfwGetWindowOpacity(window: GLFWWindow?): Float

@GLFW
expect fun glfwSetWindowOpacity(window: GLFWWindow?, opacity: Float)

@GLFW
expect fun glfwIconifyWindow(window: GLFWWindow?)

@GLFW
expect fun glfwRestoreWindow(window: GLFWWindow?)

@GLFW
expect fun glfwMaximiseWindow(window: GLFWWindow?)

@GLFW
expect fun glfwShowWindow(window: GLFWWindow?)

@GLFW
expect fun glfwHideWindow(window: GLFWWindow?)

@GLFW
expect fun glfwFocusWindow(window: GLFWWindow?)

@GLFW
expect fun glfwRequestWindowAttention(window: GLFWWindow?)

@GLFW
expect fun glfwGetWindowMonitor(window: GLFWWindow?): GLFWMonitor?

@GLFW
expect fun glfwSetWindowMonitor(
	window: GLFWWindow?,
	monitor: GLFWMonitor?,
	xPos: Int,
	yPos: Int,
	width: Int,
	height: Int,
	refreshRate: Int
)

@GLFW
expect fun glfwGetWindowAttrib(window: GLFWWindow?, attrib: Int): Int

@GLFW
expect fun glfwSetWindowAttrib(window: GLFWWindow?, attrib: Int, value: Int)

@GLFW
expect fun glfwSetWindowUserPointer(window: GLFWWindow?, pointer: Ptr<*>?)

@GLFW
expect fun glfwGetWindowUserPointer(window: GLFWWindow?): Ptr<*>?

// GLFWWindowPosFun glfwSetWindowPosCallback(GLFWWindow *window, GLFWWindowPosFun callback)

// GLFWWindowSizeFun glfwSetWindowSizeCallback(GLFWWindow *window, GLFWWindowSizeFun callback)

// GLFWWindowCloseFun glfwSetWindowCloseCallback(GLFWWindow *window, GLFWWindowCloseFun callback)

// GLFWWindowRefreshFun glfwSetWindowRefreshCallback(GLFWWindow *window, GLFWWindowRefreshFun callback)

// GLFWWindowFocusFun glfwSetWindowFocusCallback(GLFWWindow *window, GLFWWindowFocusFun callback)

// GLFWWindowIconifyFun glfwSetWindowIconifyCallback(GLFWWindow *window, GLFWWindowIconifyFun callback)

// GLFWWindowMaximiseFun glfwSetWindowMaximiseCallback(GLFWWindow *window, GLFWWindowMaximiseFun callback)

// GLFWFramebufferSizeFun glfwSetFramebufferSizeCallback(GLFWWindow *window, GLFWFramebufferSizeFun callback)

@GLFW
expect fun glfwSetFramebufferSizeCallback(window: GLFWWindow?, callback: GLFWFramebufferSizeFun?)

// GLFWWindowContentScaleFun glfwSetWindowContentScaleCallback(GLFWWindow *window, GLFWWindowContentScaleFun callback)

@GLFW
expect fun glfwPollEvents()

@GLFW
expect fun glfwWaitEvents()

@GLFW
expect fun glfwWaitEventsTimeout(timeout: Double)

@GLFW
expect fun glfwPostEmptyEvent()

@GLFW
expect fun glfwSwapBuffers(window: GLFWWindow?)