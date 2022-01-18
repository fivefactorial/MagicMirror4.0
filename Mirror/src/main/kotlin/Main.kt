import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.drawable.Text
import se.fivefactorial.magicmirror.ui.drawable.center
import se.fivefactorial.magicmirror.ui.drawable.text
import se.fivefactorial.magicmirror.ui.screen.ExampleScreen
import se.fivefactorial.magicmirror.ui.settings.DefaultSettings
import se.fivefactorial.magicmirror.ui.settings.DevelopmentSettings
import javax.swing.Timer

fun main(args: Array<String>) {

    val settings = if (args.toList().contains("develop")) DevelopmentSettings else DefaultSettings

    val timer = Timer(1200) {
        settings.debug = !settings.debug }
    timer.start()
    val ui = MirrorUI(settings = settings) {
        timer.stop()
        println("A message to show that the application was terminated correctly")
    }.apply {
        show(ExampleScreen())
        visible = true
    }

    /*
    Thread.sleep(5000)
    ui.setFullscreen()
    Thread.sleep(5000)
    ui.stop()
    */


}