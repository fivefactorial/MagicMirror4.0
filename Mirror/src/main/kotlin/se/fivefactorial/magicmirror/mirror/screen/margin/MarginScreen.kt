package se.fivefactorial.magicmirror.mirror.screen.margin

import se.fivefactorial.magicmirror.mirror.screen.mirror.MirrorScreen
import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.stack
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.Screen
import java.util.*

class MarginScreen : Screen() {
    override fun setup() {
        add(center(stack(center(text { "Setting up margin" }), center(text { "Refer to the system console" }))))
    }

    override fun run() {

        val scanner = Scanner(System.`in`)

        println("You will be prompted about seeing a line on the screen, simply respond with a y (yes) or a n (no).")





        //ui.show(MirrorScreen())

    }
}