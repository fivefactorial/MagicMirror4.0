package se.fivefactorial.magicmirror.mirror.screen.mirror

import se.fivefactorial.magicmirror.mirror.MirrorException
import se.fivefactorial.magicmirror.ui.screen.Screen

class MirrorScreen : Screen() {
    override fun setup() {
        settings.margins ?: throw MirrorException("Missing margins")
    }

    override fun run() {

    }

}