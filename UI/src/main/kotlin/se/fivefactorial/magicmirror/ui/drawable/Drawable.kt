package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Rectangle

/**
 * Represents something that can be drawn on a Screen
 */
abstract class Drawable {

    protected lateinit var settings: UISettings

    /**
     * The valid bounds where they drawable exists. Set by a parent
     * and should be overwritten by all container implementations.
     */
    internal open var bounds: Rectangle = Rectangle()

    /**
     * Returns the preferred size of the drawable.
     */
    internal abstract fun getPreferredSize(): Dimension

    /**
     * Draws the drawable on the Graphics2D object.
     */
    internal abstract fun draw(g: Graphics2D)

    /**
     * Implemented in each subclass to propagate the settings variable.
     */
    internal open fun setup(settings: UISettings) {
        this.settings = settings
    }

    /**
     * Draws a rectangle around the given rectangle bounds
     */
    protected fun Graphics2D.drawRect(rectangle: Rectangle) {
        drawRect(rectangle.x, rectangle.y, rectangle.width - 1, rectangle.height - 1)
    }

    protected fun Graphics2D.debug(block: Graphics2D.() -> Unit) {
        if (settings.debug) {
            val oldColor = color
            val oldStroke = stroke
            color = settings.debugColor
            block()
            color = oldColor
            stroke = oldStroke
        }
    }


}