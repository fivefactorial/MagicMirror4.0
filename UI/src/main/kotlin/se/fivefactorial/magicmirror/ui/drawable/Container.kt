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
}