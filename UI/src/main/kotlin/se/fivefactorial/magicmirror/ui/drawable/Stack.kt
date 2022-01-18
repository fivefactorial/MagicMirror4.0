package se.fivefactorial.magicmirror.ui.drawable

import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class Stack internal constructor(vararg children: Drawable) : Container(children.toMutableList()) {

    override var bounds: Rectangle = Rectangle()
        set(value) {
            val height = value.height / children.size
            for (i in children.indices) {
                children[i].bounds = Rectangle(value.x, value.y + height * i, value.width, height)
            }
            field = value
        }

    override fun getPreferredSize(): Dimension {
        val width: Int = children.maxOfOrNull { it.getPreferredSize().width } ?: 0
        val height: Int = children.size * (children.maxOfOrNull { it.getPreferredSize().height } ?: 0)
        return Dimension(width, height)
    }

    override fun draw(g: Graphics2D) {
        children.forEach { it.draw(g) }
        if (!settings.debug) return
        g.color = settings.debugColor
        children.forEach { g.drawRect(it.bounds.x, it.bounds.y, it.bounds.width - 1, it.bounds.height - 1) }
    }
}