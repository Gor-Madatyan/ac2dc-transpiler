package org.gormad.ac2dc.utils
import com.sun.jna.Native

internal fun loadFromPath(path: String): Plugin {
    return Native.load(path, Plugin::class.java)
}

fun getTranspiller(path: String): AC2DCTranspiler = AC2DCTranspiler(loadFromPath(path))