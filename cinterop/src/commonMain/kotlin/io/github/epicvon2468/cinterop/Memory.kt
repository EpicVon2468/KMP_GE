package io.github.epicvon2468.cinterop

//expect interface Memory// {
//
//expect fun Memory.alloc(size: Long, align: Int): NativePointed
//
//fun Memory.alloc(size: Int, align: Int): NativePointed = this.alloc(size.toLong(), align)
//
////}
//
//expect interface FreeableMemory : Memory// {
//
//expect fun FreeableMemory.free(mem: NativePointer)
//
//fun FreeableMemory.free(pointed: NativePointed) = this.free(pointed.rawPtr)
//
////}
//
//expect object HeapMemory : FreeableMemory