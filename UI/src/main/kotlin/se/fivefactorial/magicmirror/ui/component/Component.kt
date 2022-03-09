package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage


/**
 * A drawable component.
 */
abstract class Component() {

    protected lateinit var settings: UISettings

    internal open var size: Dimension = Dimension()

    /**
     * Returns the preferred size of the drawable.
     */
    internal abstract fun getPreferredSize(): Dimension


    internal fun draw() =
        BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB).apply {
            draw(graphics as Graphics2D)
        }

    internal abstract fun draw(g: Graphics2D)
}