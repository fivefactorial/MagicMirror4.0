package se.fivefactorial.magicmirror.ui

import java.awt.Color

interface UISettings {
    val background: Color
    val textColor: Color
    val debugColor: Color
    var debug: Boolean
    val fps: Int
}

