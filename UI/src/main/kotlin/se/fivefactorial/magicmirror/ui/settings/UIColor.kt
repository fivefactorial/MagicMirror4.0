package se.fivefactorial.magicmirror.ui.settings

import java.awt.Color

class UIColor(private val rgb: Int) {

    companion object {
        val WHITE = UIColor(0xFFFFFF)
        val BLACK = UIColor(0x000000)
        val RED = UIColor(0xFF0000)
    }

    fun toColor() = Color(rgb)
}

