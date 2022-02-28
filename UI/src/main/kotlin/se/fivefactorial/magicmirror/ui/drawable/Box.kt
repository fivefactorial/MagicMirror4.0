package se.fivefactorial.magicmirror.ui.drawable

import java.awt.Dimension
import java.awt.Graphics2D

class Box : Drawable() {
    override fun getPreferredSize() = bounds.size


    override fun draw(g: Graphics2D) {
        g.uiColor = settings.debugColor
        g.drawRect(bounds)
    }
}