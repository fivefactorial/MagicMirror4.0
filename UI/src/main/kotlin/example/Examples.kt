package example

import example.screen.ExampleScreen
import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.UISettings

internal fun main() {
    val settings = UISettings()
    settings.debug = true

    val screen = ExampleScreen()

    val ui = MirrorUI("Example", settings)
    ui.show(screen)
    ui.visible = true
}