package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.Container
import se.fivefactorial.magicmirror.ui.drawable.Drawable
import se.fivefactorial.magicmirror.ui.drawable.Text
import se.fivefactorial.magicmirror.ui.settings.NoSettingsException
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Rectangle
import javax.swing.JPanel
import javax.swing.Timer

abstract class Screen {

    private var settings: UISettings? = null
        get() = field ?: throw NoSettingsException("Settings not loaded into Screen")

    private val timer by lazy { Timer(1000 / settings!!.fps) { component.repaint() } }

    private val container = Container()

    val component by lazy {
        object : JPanel() {
            init {
                background = settings?.background
            }

            override fun paint(g: Graphics) {
                super.paint(g)
                container.bounds = bounds
                container.draw(g as Graphics2D, settings!!)
            }
        }
    }

    fun add(drawable: Drawable) = container.add(drawable)

    internal fun setup(settings: UISettings) {
        this.settings = settings
    }

    internal fun start() = timer.start()
    internal fun stop() = timer.stop()

}