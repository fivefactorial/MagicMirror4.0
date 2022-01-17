package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

class Container(vararg children: Drawable) : Drawable() {

    private val children: MutableList<Drawable> = children.toMutableList<Drawable>()

    override var bounds: Rectangle = Rectangle()
        set(value) {
            children.forEach { it.bounds = value }
            field = value
        }

    override fun getPreferredSize(): Dimension {
        val width: Int = children.map { it.getPreferredSize().width }.maxOrNull() ?: 0
        val height: Int = children.map { it.getPreferredSize().height }.maxOrNull() ?: 0
        return Dimension(width, height)
    }

    override fun draw(g: Graphics2D, settings: UISettings) {
        children.forEach { it.draw(g, settings) }
    }

    fun add(drawable: Drawable) {
        children.add(drawable)
    }

}

fun container(vararg children: Drawable) = Container(*children)
