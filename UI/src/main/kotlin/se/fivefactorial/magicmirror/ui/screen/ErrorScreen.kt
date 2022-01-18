package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.text

internal class ErrorScreen(e: Throwable) : Screen() {

    override fun setup() {
        add(center(text {"The system has encountered an error"}))
    }

    override fun run() {

    }
}