package se.fivefactorial.magicmirror.ui

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.awt.Color
import java.awt.Font

@Serializable
data class UISettings (
    @Contextual
    val background: Color = Color.BLACK,
    @Contextual
    val textColor: Color = Color.WHITE,
    @Contextual
    val debugColor: Color = Color.RED,
    var debug: Boolean = false,
    val fps: Int = 30,
    @Contextual
    val defaultTextFont: Font = Font("Verdana", Font.PLAIN, 25),
)