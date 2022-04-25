package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.component.support.Color
import se.fivefactorial.magicmirror.ui.component.support.Margin
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.image.BufferedImage


/**
 * A drawable component.
 */
abstract class Component() {

    protected lateinit var settings: UISettings

    var size: Dimension = Dimension()
    var margin: Margin = Margin.NO_MARGIN
    var preferredSize: Dimension? = null
        protected set
    protected val contentSize
        get() = Dimension(size.width - margin.left - margin.right, size.height - margin.top - margin.bottom)

    internal fun draw() =
        createImage().apply {
            val g2 = graphics as Graphics2D
            drawBackground(g2)

            val content = createImage(margin).apply {
                val contentG2 = graphics as Graphics2D
                draw(contentG2)
                if (settings.debug) drawDebug(contentG2)
            }

            g2.drawImage(content, margin.left, margin.top, null)
        }

    abstract fun draw(g: Graphics2D)

    open fun drawBackground(g: Graphics2D) {}

    open fun drawDebug(g: Graphics2D) {}

    internal open fun setup(settings: UISettings) {
        this.settings = settings
    }

    private fun createImage() =
        BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB)

    private fun createImage(margin: Margin) = BufferedImage(
        size.width - margin.left - margin.right,
        size.height - margin.top - margin.bottom,
        BufferedImage.TYPE_INT_ARGB
    )

    protected fun Graphics2D.setColor(color: Color) {
        this.color = java.awt.Color(color.red, color.green, color.blue, color.alpha)
    }
}