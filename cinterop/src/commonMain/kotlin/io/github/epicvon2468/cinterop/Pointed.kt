package io.github.epicvon2468.cinterop

expect open class NativePointed// {

expect val NativePointed?.rawPtr: NativePointer

//}

inline fun <reified T : NativePointed> interpretPointed(pointer: NativePointer): T = interpretNullablePointed(pointer)!!

expect inline fun <reified T : NativePointed> interpretNullablePointed(pointer: NativePointer): T?

//fun interpretOpaquePointed(pointer: NativePointer): NativePointed = interpretPointed<OpaqueNativePointed>(pointer)

//fun interpretNullableOpaquePointed(pointer: NativePointer): NativePointed? = interpretNullablePointed<OpaqueNativePointed>(pointer)

inline fun <reified T : NativePointed> NativePointed.reinterpret(): T = interpretPointed(this.rawPtr)