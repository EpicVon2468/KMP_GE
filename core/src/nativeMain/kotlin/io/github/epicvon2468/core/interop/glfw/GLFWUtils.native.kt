@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core.interop.glfw

import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi

actual typealias Ptd = CPointed

actual typealias Ptr<T> = CPointer<T>