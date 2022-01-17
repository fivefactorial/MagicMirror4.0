package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Canvas
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics2D

class Text internal constructor() : Drawable() {

    private val font: Font = Font("Verdana", Font.PLAIN, 25)
    private val fontMetrics = Canvas().getFontMetrics(font)
    override fun getPreferredSize(): Dimension {
        fontMetrics.let { return Dimension(it.stringWidth("hej"), it.height) }
    }

    override fun draw(g: Graphics2D, settings: UISettings) {
        g.color = settings.textColor
        g.font = font
        g.drawString("hej", bounds.x, bounds.y + fontMetrics.ascent)

        if (!settings.debug) return
        g.color = settings.debugColor
        g.drawRect(bounds)
    }

}