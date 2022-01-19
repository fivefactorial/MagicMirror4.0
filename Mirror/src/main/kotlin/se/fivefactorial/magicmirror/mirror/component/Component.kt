package se.fivefactorial.magicmirror.mirror.component

import se.fivefactorial.magicmirror.ui.drawable.Container
import se.fivefactorial.magicmirror.ui.drawable.Drawable
import se.fivefactorial.magicmirror.ui.drawable.absolute
import se.fivefactorial.magicmirror.ui.drawable.group

abstract class Component<T : ComponentSettings>(val settings: T) {

    protected val container: Container = group()
    val drawable: Drawable = absolute(container, settings.position, settings.size)

    abstract fun setup()
}