package se.fivefactorial.magicmirror.ui

import java.awt.Color
import java.awt.Font

interface UISettings {
    val background: Color
    val textColor: Color
    val debugColor: Color
    var debug: Boolean
    val fps: Int
    val defaultTextFont: Font
    val title: String
}

