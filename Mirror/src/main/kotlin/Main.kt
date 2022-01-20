import se.fivefactorial.magicmirror.mirror.screen.loading.LoadingScreen
import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.settings.DefaultSettings
import se.fivefactorial.magicmirror.ui.settings.DevelopmentSettings

fun main(args: Array<String>) {

    val settings = if (args.toList().contains("develop")) DevelopmentSettings else DefaultSettings

    MirrorUI(settings.title, settings) {
        println("A message to show that the application was terminated correctly")
    }.apply {
        show(LoadingScreen())
        visible = true
    }
}