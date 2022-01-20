package se.fivefactorial.magicmirror.mirror.screen.loading

import se.fivefactorial.magicmirror.mirror.screen.mirror.MirrorScreen
import se.fivefactorial.magicmirror.modules.clock.ClockComponent
import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.circularSpinner
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.Screen

class LoadingScreen : Screen() {

    private val clock = ClockComponent().apply { setup() }

    override fun setup() {
        println("Setup")
        add(center(circularSpinner(150)))
        add(center(text { "Loading" }))
    }

    override fun run() {
        println("Run")
        Thread.sleep(2000)
        ui.show(MirrorScreen())
    }
}