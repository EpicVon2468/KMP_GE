package io.github.epicvon2468.cinterop

import kotlin.reflect.full.primaryConstructor

actual open class NativePointed internal constructor(@JvmField internal val value: NativePointer)// {

actual val NativePointed?.rawPtr: NativePointer get() = this?.value ?: NULL

//}

// https://github.com/JetBrains/kotlin/blob/72dc3dcf15c6d6be09ea76d5cd2bfde10153c9d0/kotlin-native/Interop/Runtime/src/jvm/kotlin/kotlinx/cinterop/JvmTypes.kt#L51
// https://github.com/JetBrains/kotlin/blob/master/kotlin-native/Interop/Runtime/src/jvm/kotlin/kotlinx/cinterop/JvmTypes.kt#L51
actual inline fun <reified T : NativePointed> interpretNullablePointed(pointer: NativePointer): T? = T::class.primaryConstructor!!.call(pointer)