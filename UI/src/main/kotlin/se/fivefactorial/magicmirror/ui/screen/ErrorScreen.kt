package se.fivefactorial.magicmirror.ui.screen

import se.fivefactorial.magicmirror.ui.drawable.absoluteSize
import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.TextSettings
import se.fivefactorial.magicmirror.ui.drawable.text

internal class ErrorScreen(e: Throwable) : Screen() {

    override fun setup() {
        val text = center(text { "The system has encountered an error" })
        add(absoluteSize(text, SizeSettings(500, 200)))
    }

    override fun run() {

    }
}