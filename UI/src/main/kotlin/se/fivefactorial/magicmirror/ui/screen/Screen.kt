package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.Group
import se.fivefactorial.magicmirror.ui.drawable.Drawable
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import javax.swing.Timer

abstract class Screen {

    private lateinit var settings: UISettings

    private val timer by lazy { Timer(1000 / settings.fps) { component.repaint() } }

    private val group = Group()

    val component by lazy {
        object : JPanel() {
            init {
                background = settings.background
            }

            override fun paint(g: Graphics) {
                super.paint(g)
                group.setup(settings)
                group.bounds = bounds
                group.draw(g as Graphics2D)
            }
        }
    }

    fun add(drawable: Drawable) = group.add(drawable)

    internal fun setup(settings: UISettings) {
        this.settings = settings
    }

    internal fun start() = timer.start()
    internal fun stop() = timer.stop()

}