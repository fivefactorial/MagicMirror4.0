import se.fivefactorial.magicmirror.ui.MirrorUI

fun main(args: Array<String>) {
    println("Hello World Mirror!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var mirrorUI = MirrorUI()

    println(mirrorUI.a())
    println(mirrorUI.b())
    println(mirrorUI.c())


}