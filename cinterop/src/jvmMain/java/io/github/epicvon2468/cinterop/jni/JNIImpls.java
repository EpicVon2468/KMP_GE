package io.github.epicvon2468.cinterop.jni;

// When generating headers, first replace all imported non-JDK classes with "Object"
// Run: "javac -h . JNIImpls.java"
// Then in the header, replace all the class references with the correct ones.
public class JNIImpls {

	static { System.loadLibrary("cinterop_jni"); }

	public static native long getNativeNullPointer();
}