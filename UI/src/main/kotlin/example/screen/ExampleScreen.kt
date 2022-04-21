package example.screen

import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.circularSpinner
import se.fivefactorial.magicmirror.ui.drawable.stack
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.Screen

internal class ExampleScreen : Screen() {

    override fun setup() {
        val start = System.currentTimeMillis()

        val stack = stack()
        stack.add(text() { "${System.currentTimeMillis() - start}ms" })
        stack.add(circularSpinner(10))
        stack.add(circularSpinner(15))
        stack.add(circularSpinner(20))

        add(circularSpinner(45))
        add(center(stack))

    }

    override fun run() {
        println("Running")
    }

}