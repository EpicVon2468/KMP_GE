package io.github.epicvon2468.cinterop

import io.github.epicvon2468.cinterop.jni.JNIImpls

actual class NativePointer internal constructor(@JvmField internal val value: Long) {// {

	override fun equals(other: Any?): Boolean {
		if (other === this) return true
		if (other !is NativePointer) return false
		if (other.value != this.value) return false
		if (other.hashCode() != this.hashCode()) return false
		return true
	}

	override fun hashCode(): Int = this.toLong().hashCode()

	override fun toString(): String = "0x${this.toLong().toString(16)}"
}

actual operator fun NativePointer.plus(offset: Long): NativePointer = NativePointer(this.value + offset)

actual fun NativePointer.toLong(): Long = this.value

@JvmField
actual val NULL: NativePointer = NativePointer(JNIImpls.getNativeNullPointer())

//}