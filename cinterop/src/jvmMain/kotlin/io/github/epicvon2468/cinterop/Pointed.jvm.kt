package io.github.epicvon2468.cinterop

actual open class NativePointed internal constructor(@JvmField internal val value: NativePointer)// {

actual val NativePointed?.rawPtr: NativePointer get() = this?.value ?: NULL

//}