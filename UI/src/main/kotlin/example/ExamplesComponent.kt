package example

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.component.ComponentCollection
import se.fivefactorial.magicmirror.ui.component.TextComponent
import se.fivefactorial.magicmirror.ui.component.support.position.AbsolutePosition
import se.fivefactorial.magicmirror.ui.component.support.Color
import se.fivefactorial.magicmirror.ui.component.support.Margin
import se.fivefactorial.magicmirror.ui.component.support.size.AbsoluteSize
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

    val text = TextComponent({ "" + System.currentTimeMillis() }, Color(0, 0, 0))
    text.margin = Margin(0)

    val text2 = TextComponent({ "" + System.currentTimeMillis() }, Color(255, 0, 0))
    text2.margin = Margin(0)

    val component = ComponentCollection().apply {
        add(text)
        add(text2, AbsolutePosition(30,30), AbsoluteSize(50,75))
        setup(settings)
    }

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

