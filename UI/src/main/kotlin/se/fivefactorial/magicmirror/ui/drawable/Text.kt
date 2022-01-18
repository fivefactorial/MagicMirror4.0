package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.settings.TextSettings
import java.awt.Canvas
import java.awt.Dimension
import java.awt.Graphics2D

class Text internal constructor(
    private val textSettings: TextSettings,
    private val text: () -> String
) : Drawable() {

    override fun getPreferredSize(settings: UISettings): Dimension {
        val font = textSettings.font ?: settings.defaultTextFont
        Canvas().getFontMetrics(font).let { return Dimension(it.stringWidth(text()), it.height) }
    }

    override fun draw(g: Graphics2D, settings: UISettings) {
        g.color = settings.textColor
        g.font = textSettings.font ?: settings.defaultTextFont
        g.drawString(text(), bounds.x, bounds.y + g.fontMetrics.ascent)

        if (!settings.debug) return
        g.color = settings.debugColor
        g.drawRect(bounds)
    }
}