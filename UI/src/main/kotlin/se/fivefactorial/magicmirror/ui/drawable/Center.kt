package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Graphics2D
import java.awt.Rectangle

/**
 * The Center drawable center its child in the x and y position within its own bounds.
 */
class Center(private val child: Drawable) : Drawable() {

    override var bounds: Rectangle = Rectangle()
        set(value) {
            val childSize = child.getPreferredSize()
            val width = Integer.min(value.width, childSize.width)
            val height = Integer.min(value.height, childSize.height)
            val x = value.x + value.width / 2 - width / 2
            val y = value.y + value.height / 2 - height / 2
            child.bounds = Rectangle(x, y, width, height)
            field = value
        }

    override fun getPreferredSize() = child.getPreferredSize()

    override fun draw(g: Graphics2D) {
        child.draw(g)

        g.debug {
            val size = 20;
            child.bounds.let {
                fillArc(it.x - size / 2, it.y + it.height / 2 - size / 2, size, size, 90, 180)
                fillArc(it.x + it.width / 2 - size / 2, it.y - size / 2, size, size, 0, 180)
                fillArc(it.x + it.width - size / 2 - 1, it.y + it.height / 2 - size / 2, size, size, 270, 180)
                fillArc(it.x + it.width / 2 - size / 2, it.y + it.height - 1 - size / 2, size, size, 180, 180)
            }
        }
    }

    override fun setup(settings: UISettings) {
        super.setup(settings)
        child.setup(settings)
    }

    override fun toString(spacing: String): String {
        val newSpacing = "$spacing  "
        return "${super.toString(spacing)}\n$newSpacing${child.toString(newSpacing)}"
    }
}