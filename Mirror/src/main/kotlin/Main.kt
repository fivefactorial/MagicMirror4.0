import se.fivefactorial.magicmirror.ui.DefaultSettings
import se.fivefactorial.magicmirror.ui.DevelopmentSettings
import se.fivefactorial.magicmirror.ui.MirrorUI

fun main(args: Array<String>) {

    val settings = if (args.toList().contains("develop")) DevelopmentSettings else DefaultSettings

    val ui = MirrorUI(settings = settings).apply { visible = true }
    Thread.sleep(2000)
    ui.setFullscreen()
    Thread.sleep(2000)
    ui.stop()
}