package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings
import java.awt.BasicStroke
import java.awt.Graphics2D
import java.awt.Rectangle

class AbsoluteSize internal constructor(
    private val child: Drawable,
    private val sizeSettings: SizeSettings
) : Drawable() {

    override var bounds: Rectangle = Rectangle()
        set(value) {
            child.bounds = value
            field = value
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