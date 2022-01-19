package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.drawable.Group
import se.fivefactorial.magicmirror.ui.drawable.Drawable
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel
import javax.swing.Timer

abstract class Screen {

    internal lateinit var settings: UISettings
    lateinit var ui: MirrorUI

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

    internal fun start() {
        setup()
        timer.start()
        object : Thread() {
            override fun run() {
                name = this@Screen::class.java.simpleName
                try {
                    this@Screen.run()
                } catch (e: Throwable) {
                    ui.show(ErrorScreen(e))
                }
            }
        }.start()
    }

    internal fun stop() = timer.stop()

    abstract fun setup()
    abstract fun run()

}