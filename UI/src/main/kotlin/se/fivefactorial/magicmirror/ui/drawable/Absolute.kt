package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.settings.PositionSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings
import java.awt.BasicStroke
import java.awt.Graphics2D
import java.awt.Rectangle

class Absolute internal constructor(
    private val child: Drawable,
    private val positionSettings: PositionSettings,
    private val sizeSettings: SizeSettings
) : Drawable() {

    @Suppress("SetterBackingFieldAssignment")
    override var bounds: Rectangle = Rectangle(positionSettings.toPoint(), sizeSettings.toDimension())
        set(_) {
            child.bounds = field
        }

    override fun getPreferredSize() = sizeSettings.toDimension()

    override fun draw(g: Graphics2D) {
        child.draw(g)
        g.debug {
            g.stroke = BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, arrayOf(9f).toFloatArray(), 0f)
            g.drawRect(bounds)
        }
    }

    override fun setup(settings: UISettings) {
        super.setup(settings)
        child.setup(settings)
    }
}