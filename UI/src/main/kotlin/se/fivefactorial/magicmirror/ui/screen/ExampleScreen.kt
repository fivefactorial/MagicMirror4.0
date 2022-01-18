package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.text

class ExampleScreen : Screen() {

    override fun setup() {
        println("Setup!")
        val start = System.currentTimeMillis()
        add(center(text() { "${System.currentTimeMillis() - start}ms" }))
    }

    override fun run() {
        println("Running")
        Thread.sleep(5000)
        throw IllegalArgumentException("Whoopsie!")
    }

}