package se.fivefactorial.magicmirror.ui.drawable

import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

/**
 * A container that contain an arbitrary amount of drawables, not ordering them.
 */
class Group internal constructor(vararg children: Drawable) : Container(
    children.toMutableList()
) {

    override var bounds: Rectangle = Rectangle()
        set(value) {
            children.forEach { it.bounds = value }
            field = value
        }

    override fun getPreferredSize(): Dimension {
        val width: Int = children.maxOfOrNull { it.getPreferredSize().width } ?: 0
        val height: Int = children.maxOfOrNull { it.getPreferredSize().height } ?: 0
        return Dimension(width, height)
    }

    override fun draw(g: Graphics2D) {
        children.forEach { it.draw(g) }
    }

}