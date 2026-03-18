package org.gormad.ac2dc

import org.gormad.ac2dc.utils.getTranspiller
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if(args.size != 2){
        System.err.println("not enough arguments")
        exitProcess(1)
    }

    val transpiler = getTranspiller(args[0])
    println(transpiler.transpile(args[1]))
}