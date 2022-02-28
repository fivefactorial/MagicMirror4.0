package se.fivefactorial.magicmirror.ui

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import se.fivefactorial.magicmirror.ui.settings.Margins
import se.fivefactorial.magicmirror.ui.settings.UIColor
import java.awt.Color
import java.awt.Font

@Serializable
data class UISettings(
    @Contextual
    val background: UIColor = UIColor.BLACK,
    @Contextual
    val textColor: UIColor = UIColor.WHITE,
    @Contextual
    val debugColor: UIColor = UIColor.RED,
    var debug: Boolean = false,
    val fps: Int = 30,
    @Contextual
    val defaultTextFont: Font = Font("Verdana", Font.PLAIN, 25),

    val margins: Margins? = null
)