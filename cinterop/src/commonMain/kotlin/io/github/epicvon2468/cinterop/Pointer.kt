package io.github.epicvon2468.cinterop

// NativePtr

expect class NativePointer// {

expect operator fun NativePointer.plus(offset: Long): NativePointer

expect fun NativePointer.toLong(): Long

//}

/**
 * The runtime value that represents a pointer to `null`; that being, a pointer to nothing.
 *
 * In almost all use cases, using [NativePointer] should prefer comparing to [NULL] rather than a nullable variable.
 */
expect val NULL: NativePointer

// Ptr

