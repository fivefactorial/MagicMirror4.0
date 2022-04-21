package se.fivefactorial.magicmirror.ui.component

import java.awt.Color
import java.awt.Graphics2D

class TextComponent : Component() {
    override fun draw(g: Graphics2D) {
        g.color = Color.GREEN
        g.drawLine(0, 0, size.width, size.height)
        g.color = Color.BLACK

        g.drawString("" + System.currentTimeMillis(), 20, 20)
    }
}