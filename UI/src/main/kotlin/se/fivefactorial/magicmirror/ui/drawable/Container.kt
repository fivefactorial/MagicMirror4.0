package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class Container internal constructor(vararg children: Drawable) : Drawable() {

    private val children: MutableList<Drawable> = children.toMutableList<Drawable>()

    override var bounds: Rectangle = Rectangle()
        set(value) {
            children.forEach { it.bounds = value }
            field = value
        }

    override fun getPreferredSize(settings: UISettings): Dimension {
        val width: Int = children.maxOfOrNull { it.getPreferredSize(settings).width } ?: 0
        val height: Int = children.maxOfOrNull { it.getPreferredSize(settings).height } ?: 0
        return Dimension(width, height)
    }

    override fun draw(g: Graphics2D, settings: UISettings) {
        children.forEach { it.draw(g, settings) }
    }

    fun add(drawable: Drawable) {
        children.add(drawable)
    }

}