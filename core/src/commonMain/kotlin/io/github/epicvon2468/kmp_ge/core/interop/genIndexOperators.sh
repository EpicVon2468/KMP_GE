#! /bin/bash

function gen {
	echo "// $1"
	echo
	echo "@JvmName(\"plus\\\$$1\")"
	echo "expect inline operator fun <T : ${1}VarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?"
	echo
	echo "@JvmName(\"plus\\\$$1\")"
	echo "inline operator fun <T : ${1}VarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()"
	echo
	echo "@JvmName(\"get\\\$$1\")"
	echo "inline operator fun <T : $1> Ptr<${1}VarOf<T>>.get(index: Long): T = (this + index)!!.pointed.value"
	echo
	echo "@JvmName(\"set\\\$$1\")"
	echo "inline operator fun <T : $1> Ptr<${1}VarOf<T>>.set(index: Long, value: T) { (this + index)!!.pointed.value = value }"
	echo
	echo "@JvmName(\"get\\\$$1\")"
	echo "inline operator fun <T : $1> Ptr<${1}VarOf<T>>.get(index: Int): T = this[index.toLong()]"
	echo
	echo "@JvmName(\"set\\\$$1\")"
	echo "inline operator fun <T : $1> Ptr<${1}VarOf<T>>.set(index: Int, value: T) { this[index.toLong()] = value }"
}

echo "@file:Suppress(\"NOTHING_TO_INLINE\", \"CanConvertToMultiDollarString\", \"FINAL_UPPER_BOUND\")"
echo "package io.github.epicvon2468.kmp_ge.core.interop"
echo
echo "import kotlin.jvm.JvmName"
echo

gen Byte
echo
gen UByte
echo
gen Int
echo
gen UInt
echo
gen Float