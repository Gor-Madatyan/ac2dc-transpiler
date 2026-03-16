package org.gormad

import loadFromPath

fun main() {
    val lib = loadFromPath("./lexlib.so")
    val otp = lib.lex("hehehe running C")

    for (c in otp.getTokensArray()) {
        println(c)
    }

    lib.free_output(otp)
}