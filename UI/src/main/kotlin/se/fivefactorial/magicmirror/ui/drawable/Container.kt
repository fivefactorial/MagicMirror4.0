package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings

abstract class Container(
    protected val children: MutableList<Drawable>
) : Drawable() {

    override fun setup(settings: UISettings) {
        super.setup(settings)
        children.forEach { drawable -> drawable.setup(settings) }
    }

    fun add(drawable: Drawable) {
        children.add(drawable)
    }

    override fun toString(spacing: String): String {
        val newSpacing = "$spacing  "
        val title = super.toString(spacing)
        return if (children.isEmpty())
            "$title (Empty)"
        else
            title + children.joinToString("") { child -> "\n$newSpacing${child.toString(newSpacing)}" }
    }
}