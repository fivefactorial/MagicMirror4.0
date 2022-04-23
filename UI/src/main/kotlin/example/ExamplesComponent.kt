package example

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.component.TextComponent
import se.fivefactorial.magicmirror.ui.component.support.Color
import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.Timer

internal fun main() {
    val frame = JFrame("Example").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    val settings = UISettings()
    settings.debug = true

    val component = TextComponent({ "" + System.currentTimeMillis() }, Color(0, 0, 0))
    component.setup(settings)
    val panel by lazy {
        object : JPanel() {
            override fun paint(g: Graphics) {
                super.paint(g)
                component.size = bounds.size
                g.drawImage(component.draw(), 0, 0, null)
            }
        }
    }

    frame.add(panel)
    frame.size = Dimension(300, 300)

    Timer(1000 / settings.fps) { panel.repaint() }.apply { start() }

    frame.isVisible = true

}

