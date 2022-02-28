package se.fivefactorial.magicmirror.mirror.screen.loading

import se.fivefactorial.magicmirror.mirror.screen.margin.MarginScreen
import se.fivefactorial.magicmirror.mirror.screen.mirror.MirrorScreen
import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.circularSpinner
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.Screen

class LoadingScreen : Screen() {

    override fun setup() {
        add(center(circularSpinner(150)))
        add(center(text { "Loading" }))
    }

    override fun run() {
        Thread.sleep(2000)

        if (settings.margins == null) ui.show(MarginScreen())
        else ui.show(MirrorScreen())
    }
}