package io.github.epicvon2468.cinterop.jni;

// javac -h . JNIImpls.java
public class JNIImpls {

	static { System.loadLibrary("cinterop_jni"); }

	public static native long getNativeNullPointer();
}