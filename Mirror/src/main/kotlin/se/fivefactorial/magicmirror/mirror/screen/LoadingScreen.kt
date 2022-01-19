package se.fivefactorial.magicmirror.mirror.screen

import se.fivefactorial.magicmirror.modules.clock.ClockComponent
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.Screen

class LoadingScreen : Screen() {

    private val clock = ClockComponent().apply { setup() }

    override fun setup() {
        println("Setup")
        add(clock.drawable)
        println(clock.drawable)
    }

    override fun run() {
        println("Run")
    }
}