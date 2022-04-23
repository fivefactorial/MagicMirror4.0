package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.component.support.Color
import java.awt.Graphics2D

class TextComponent(private val text: () -> String, private val color: Color? = null) : Component() {

    constructor (text: String, color: Color? = null) : this({ text }, color)

    override fun draw(g: Graphics2D) {
        color?.run {
            g.setColor(this)
        }

        g.drawString(text(), 20, 20)
    }
}