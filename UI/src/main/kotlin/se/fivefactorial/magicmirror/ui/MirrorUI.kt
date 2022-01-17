package se.fivefactorial.magicmirror.ui

import java.awt.Dimension
import java.awt.GraphicsEnvironment
import java.awt.Toolkit
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JFrame
import javax.swing.SwingUtilities

class MirrorUI(private val onClose: () -> Any = {}) {

    private val ui: JFrame = JFrame().apply {
        val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
        setSize(screenSize.width / 2, screenSize.height / 2)
        setLocation(screenSize.width / 4, screenSize.height / 4)
        addWindowListener(object : WindowListener {
            override fun windowOpened(e: WindowEvent?) {}

            override fun windowClosing(e: WindowEvent?) {
                stop()
            }

            override fun windowClosed(e: WindowEvent?) {}

            override fun windowIconified(e: WindowEvent?) {}

            override fun windowDeiconified(e: WindowEvent?) {}

            override fun windowActivated(e: WindowEvent?) {}

            override fun windowDeactivated(e: WindowEvent?) {}

        })
        defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
    }

    var visible: Boolean
        get() = ui.isVisible
        set(value) {
            ui.isVisible = value
        }

    fun setFullscreen() = SwingUtilities.invokeLater {
        ui.dispose()
        ui.isUndecorated = true
        val device = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice
        device.fullScreenWindow = ui
        ui.isVisible = true
    }

    fun stop() = SwingUtilities.invokeLater {
        visible = false
        ui.dispose()
        onClose()
    }

}