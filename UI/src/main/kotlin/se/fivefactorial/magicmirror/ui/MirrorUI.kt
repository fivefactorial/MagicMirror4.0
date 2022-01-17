package se.fivefactorial.magicmirror.ui

import se.fivefactorial.magicmirror.ui.screen.Screen
import se.fivefactorial.magicmirror.ui.settings.DefaultSettings
import java.awt.*
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

/**
 * The base of the MirrorUI framework. Creates a frame where you can house Screens.
 *
 * @param title the Title of the frame, displayed when not in fullscreen. Default, no text
 * @param onClose a callback method that is run when the window is closed. Default, do nothing
 */
class MirrorUI(
    private val title: String? = null,
    private val settings: UISettings = DefaultSettings,
    private val onClose: () -> Any = {}
) {

    private val ui: JFrame = JFrame(title).apply {
        val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
        setSize(screenSize.width / 2, screenSize.height / 2)
        setLocation(screenSize.width / 4, screenSize.height / 4)
        addWindowListener(object : WindowListener {
            override fun windowClosing(e: WindowEvent?) {
                stop()
            }

            override fun windowOpened(e: WindowEvent?) {}
            override fun windowClosed(e: WindowEvent?) {}
            override fun windowIconified(e: WindowEvent?) {}
            override fun windowDeiconified(e: WindowEvent?) {}
            override fun windowActivated(e: WindowEvent?) {}
            override fun windowDeactivated(e: WindowEvent?) {}
        })
        defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
    }

    private val panel: JPanel = JPanel().apply {
        layout = BorderLayout()
        background = settings.background
    }

    private var currentScreen: Screen? = null

    var visible: Boolean
        get() = ui.isVisible
        set(value) {
            ui.isVisible = value
        }

    init {
        ui.add(panel, BorderLayout.CENTER)
    }

    fun setFullscreen() = SwingUtilities.invokeLater {
        ui.dispose()
        ui.isUndecorated = true
        val device = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice
        device.fullScreenWindow = ui
        ui.isVisible = true
    }

    fun show(screen: Screen) {
        currentScreen?.stop()
        screen.setup(settings)
        panel.apply {
            removeAll()
            add(screen.component)
            updateUI()
        }
        screen.start()
        currentScreen = screen
    }

    fun stop() = SwingUtilities.invokeLater {
        visible = false
        currentScreen?.stop()
        ui.dispose()
        onClose()
    }

}