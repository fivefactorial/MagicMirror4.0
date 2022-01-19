package se.fivefactorial.magicmirror.ui.drawable

import java.awt.Dimension
import java.awt.Graphics2D
import kotlin.math.min

class CircularSpinner(private val size: Int) : Drawable() {

    override fun getPreferredSize(): Dimension {
        return Dimension(size, size)
    }

    override fun draw(g: Graphics2D) {
        g.color = settings.textColor
        val size = min(bounds.width, bounds.height)
        val x = bounds.x + bounds.width / 2 - size / 2
        val y = bounds.y + bounds.height / 2 - size / 2
        val angle = 360 - (System.currentTimeMillis() / 12).toInt() % 360
        (0..4).forEach {
            g.fillArc(x, y, size, size, angle + 72 * it, 48)
        }
        val sizeSmall = (size * 0.85).toInt()
        val xSmall = bounds.x + bounds.width / 2 - sizeSmall / 2
        val ySmall = bounds.y + bounds.height / 2 - sizeSmall / 2
        g.color = settings.background
        g.fillOval(xSmall, ySmall, sizeSmall, sizeSmall)

        g.debug {
            drawOval(x, y, size, size)
        }
    }
}
