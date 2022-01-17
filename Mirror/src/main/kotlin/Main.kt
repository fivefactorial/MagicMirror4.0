import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.drawable.Text
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.ExampleScreen
import se.fivefactorial.magicmirror.ui.settings.DefaultSettings
import se.fivefactorial.magicmirror.ui.settings.DevelopmentSettings

fun main(args: Array<String>) {

    val settings = if (args.toList().contains("develop")) DevelopmentSettings else DefaultSettings

    val ui = MirrorUI(settings = settings) {
        println("A message to show that the application was terminated correctly")
    }.apply {
        show(ExampleScreen().apply { add(text()) })
        visible = true
    }

    Thread.sleep(1000)
    settings.debug = true

    /*
    Thread.sleep(5000)
    ui.setFullscreen()
    Thread.sleep(5000)
    ui.stop()
    */


}