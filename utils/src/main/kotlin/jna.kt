package org.gormad.ac2dc.utils
import com.sun.jna.Native

fun loadFromPath(path: String): Lexer {
    return Native.load(path, Lexer::class.java)
}