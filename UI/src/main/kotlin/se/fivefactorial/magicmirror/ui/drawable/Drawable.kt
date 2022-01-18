package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

/**
 * Represents something that can be drawn on a Screen
 */
abstract class Drawable {

    /**
     * The valid bounds where they drawable exists. Set by a parent
     * and should be overwritten by all container implementations.
     */
    internal open var bounds: Rectangle = Rectangle()

    /**
     * Returns the preferred size of the drawable.
     */
    internal abstract fun getPreferredSize(settings: UISettings): Dimension

    /**
     * Draws the drawable on the Graphics2D object.
     */
    internal abstract fun draw(g: Graphics2D, settings: UISettings)

    /**
     * Draws a rectangle around the given rectangle bounds
     */
    protected fun Graphics2D.drawRect(rectangle: Rectangle) {
        drawRect(rectangle.x, rectangle.y, rectangle.width - 1, rectangle.height - 1)
    }
}