package org.gormad.ac2dc

import org.gormad.ac2dc.utils.loadFromPath
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if(args.size != 2){
        System.err.println("not enough arguments")
        exitProcess(1)
    }

    val lib = loadFromPath(args[0])
    val otp = lib.lex(args[1])

    for (c in otp.getTokensArray()) {
        println(c)
    }

    lib.free_output(otp)
}