package org.gormad.ac2dc

import org.gormad.ac2dc.utils.getTranspiller
import org.gormad.ac2dc.utils.transpileToFile
import java.nio.file.Path
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if(args.size != 3){
        System.err.println("not enough arguments")
        System.err.println("Usage: <plugin-path> <src> <output>")
        exitProcess(1)
    }
    val transpiler = getTranspiller(args[0])

    transpiler.transpileToFile(Path.of(args[1]), Path.of(args[2]))
}