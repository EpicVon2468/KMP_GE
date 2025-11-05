@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE", "FINAL_UPPER_BOUND", "ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT")
package io.github.epicvon2468.kmp_ge.core.interop

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.plus

actual inline operator fun <T : ByteVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index

actual inline operator fun <T : UByteVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index

actual inline operator fun <T : IntVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index

actual inline operator fun <T : UIntVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index

actual inline operator fun <T : FloatVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index