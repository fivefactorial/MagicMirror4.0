import se.fivefactorial.magicmirror.ui.MirrorUI

fun main(args: Array<String>) {

    val ui = MirrorUI().apply { visible = true }
    Thread.sleep(10000)
    ui.stop()
}