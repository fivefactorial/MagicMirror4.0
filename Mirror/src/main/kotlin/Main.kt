import se.fivefactorial.magicmirror.mirror.screen.loading.LoadingScreen
import se.fivefactorial.magicmirror.mirror.settings.SettingsHandler
import se.fivefactorial.magicmirror.ui.MirrorUI
import se.fivefactorial.magicmirror.ui.settings.DefaultSettings
import se.fivefactorial.magicmirror.ui.settings.DevelopmentSettings

fun main(args: Array<String>) {

    try {
        val settingsHandler = SettingsHandler().apply { println(load()) }

        if (args[0] != "leave") return

        val settings = if (args.toList().contains("develop")) DevelopmentSettings else DefaultSettings

        MirrorUI(settings.title, settings) {
            println("A message to show that the application was terminated correctly")
        }.apply {
            show(LoadingScreen())
            visible = true
        }

    } catch (e: Throwable) {
        System.err.println("The system encountered an error")
        System.err.println(e.message)
        e.printStackTrace()
    }
}