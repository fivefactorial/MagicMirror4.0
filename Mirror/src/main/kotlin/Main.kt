import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.UnrecognizedOptionException
import com.xenomachina.argparser.default
import se.fivefactorial.magicmirror.mirror.screen.loading.LoadingScreen
import se.fivefactorial.magicmirror.mirror.settings.SettingsHandler
import se.fivefactorial.magicmirror.ui.MirrorUI

fun main(args: Array<String>) {

    val arguments =
        try {
            ArgParser(args).parseInto(::Arguments)
        } catch (e: UnrecognizedOptionException) {
            println(e.message)
            return
        }

    try {
        val settingsHandler = SettingsHandler()
        val settings = settingsHandler.load(arguments.settings)

        MirrorUI(settings.name, settings.ui) {
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

class Arguments(parser: ArgParser) {
    val settings by parser.positional("settings filename").default("settings.json")
}