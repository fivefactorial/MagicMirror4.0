package example

import example.screen.ExampleScreen
import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.UISettings

internal fun main() {
    var settings = UISettings()

    var screen = ExampleScreen()

    var ui = MirrorUI(settings = settings)
    ui.show(screen)
    ui.visible = true
}