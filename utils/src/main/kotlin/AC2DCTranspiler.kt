package org.gormad.ac2dc.utils

class AC2DCTranspiler internal constructor(private val lib: Plugin) {
    private var otp: LexerOutput.ByValue? = null

    fun transpile(src: String): String{
        otp = lib.lex(src)
        return otp!!.getTokensArray().reversed().joinToString(" ").also{cleanUp()}
    }

    private fun cleanUp(){
        otp?.let {lib.freeOutput(otp!!)}
        otp = null
    }
}