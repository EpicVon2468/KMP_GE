@file:Suppress("NOTHING_TO_INLINE", "CanConvertToMultiDollarString", "FINAL_UPPER_BOUND")
package io.github.epicvon2468.kmp_ge.core.interop

import kotlin.jvm.JvmName

// Byte

@JvmName("plus\$Byte")
expect inline operator fun <T : ByteVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

@JvmName("plus\$Byte")
inline operator fun <T : ByteVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

@JvmName("get\$Byte")
inline operator fun <T : Byte> Ptr<ByteVarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value

@JvmName("set\$Byte")
inline operator fun <T : Byte> Ptr<ByteVarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }

@JvmName("get\$Byte")
inline operator fun <T : Byte> Ptr<ByteVarOf<T>>.get(index: Int): T = this[index.toLong()]

@JvmName("set\$Byte")
inline operator fun <T : Byte> Ptr<ByteVarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }

// UByte

@JvmName("plus\$UByte")
expect inline operator fun <T : UByteVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

@JvmName("plus\$UByte")
inline operator fun <T : UByteVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

@JvmName("get\$UByte")
inline operator fun <T : UByte> Ptr<UByteVarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value

@JvmName("set\$UByte")
inline operator fun <T : UByte> Ptr<UByteVarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }

@JvmName("get\$UByte")
inline operator fun <T : UByte> Ptr<UByteVarOf<T>>.get(index: Int): T = this[index.toLong()]

@JvmName("set\$UByte")
inline operator fun <T : UByte> Ptr<UByteVarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }

// Int

@JvmName("plus\$Int")
expect inline operator fun <T : IntVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

@JvmName("plus\$Int")
inline operator fun <T : IntVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

@JvmName("get\$Int")
inline operator fun <T : Int> Ptr<IntVarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value

@JvmName("set\$Int")
inline operator fun <T : Int> Ptr<IntVarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }

@JvmName("get\$Int")
inline operator fun <T : Int> Ptr<IntVarOf<T>>.get(index: Int): T = this[index.toLong()]

@JvmName("set\$Int")
inline operator fun <T : Int> Ptr<IntVarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }

// UInt

@JvmName("plus\$UInt")
expect inline operator fun <T : UIntVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

@JvmName("plus\$UInt")
inline operator fun <T : UIntVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

@JvmName("get\$UInt")
inline operator fun <T : UInt> Ptr<UIntVarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value

@JvmName("set\$UInt")
inline operator fun <T : UInt> Ptr<UIntVarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }

@JvmName("get\$UInt")
inline operator fun <T : UInt> Ptr<UIntVarOf<T>>.get(index: Int): T = this[index.toLong()]

@JvmName("set\$UInt")
inline operator fun <T : UInt> Ptr<UIntVarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }

// Float

@JvmName("plus\$Float")
expect inline operator fun <T : FloatVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

@JvmName("plus\$Float")
inline operator fun <T : FloatVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

@JvmName("get\$Float")
inline operator fun <T : Float> Ptr<FloatVarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value

@JvmName("set\$Float")
inline operator fun <T : Float> Ptr<FloatVarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }

@JvmName("get\$Float")
inline operator fun <T : Float> Ptr<FloatVarOf<T>>.get(index: Int): T = this[index.toLong()]

@JvmName("set\$Float")
inline operator fun <T : Float> Ptr<FloatVarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }