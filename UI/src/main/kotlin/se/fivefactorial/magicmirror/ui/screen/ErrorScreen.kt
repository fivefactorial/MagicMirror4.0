package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.stack
import se.fivefactorial.magicmirror.ui.drawable.text

internal class ErrorScreen(val e: Throwable) : Screen() {

    override fun setup() {
        val text = center(text { "The system has encountered an error" })
        val errorMessage = center(text { e.message })
        add(center(stack(text, errorMessage)))
    }

    override fun run() {

    }
}