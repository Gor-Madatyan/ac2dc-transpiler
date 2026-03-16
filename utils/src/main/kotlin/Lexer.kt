package org.gormad.ac2dc.utils
import com.sun.jna.Library
import com.sun.jna.Pointer
import com.sun.jna.Structure

@Structure.FieldOrder("size", "tokens")
open class LexerOutput: Structure() {
    class ByValue : LexerOutput(), Structure.ByValue

    @JvmField
    var size: Int = 0
    @JvmField
    var tokens: Pointer? = null

    fun getTokensArray(): Array<String> {
        return tokens?.getStringArray(0, size) ?: emptyArray()
    }
}

interface Lexer: Library {
    fun lex(str: String): LexerOutput.ByValue
    fun free_output(out: LexerOutput.ByValue)
}