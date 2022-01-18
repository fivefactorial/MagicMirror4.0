package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.drawable.settings.TextSettings
import java.awt.Canvas
import java.awt.Dimension
import java.awt.Graphics2D

/**
 * Draws a text on the screen with the given settings
 */
class Text internal constructor(
    private val textSettings: TextSettings,
    private val text: () -> String
) : Drawable() {

    override fun getPreferredSize(): Dimension {
        val font = textSettings.font ?: settings.defaultTextFont
        Canvas().getFontMetrics(font).let { return Dimension(it.stringWidth(text()), it.height) }
    }

    override fun draw(g: Graphics2D) {
        g.color = settings.textColor
        g.font = textSettings.font ?: settings.defaultTextFont
        g.drawString(text(), bounds.x, bounds.y + g.fontMetrics.ascent)

        g.debug {
            drawRect(bounds)
        }
    }
}