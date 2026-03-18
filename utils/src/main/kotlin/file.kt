package org.gormad.ac2dc.utils

import java.nio.file.Files
import java.nio.file.Path

fun AC2DCTranspiler.transpileToFile(path1: Path, path2: Path) {
    var lines = Files.readAllLines(path1)
    lines = lines.map { line -> transpile(line.trim())}

    Files.write(path2, lines)
}