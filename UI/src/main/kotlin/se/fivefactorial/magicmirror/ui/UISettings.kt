package se.fivefactorial.magicmirror.ui

import java.awt.Color

interface UISettings {
    val background: Color
    val textColor: Color
    val debugColor: Color
}

object DefaultSettings : UISettings {
    override val background: Color = Color.BLACK
    override val textColor: Color = Color.WHITE
    override val debugColor: Color = Color.RED
}

object DevelopmentSettings : UISettings {
    override val background: Color = Color.WHITE
    override val textColor: Color = Color.BLACK
    override val debugColor: Color = Color.RED
}