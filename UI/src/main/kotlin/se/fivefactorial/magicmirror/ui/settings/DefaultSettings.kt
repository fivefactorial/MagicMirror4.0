package se.fivefactorial.magicmirror.ui.settings

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Color
import java.awt.Font

object DefaultSettings : UISettings {
    override val background: Color = Color.BLACK
    override val textColor: Color = Color.WHITE
    override val debugColor: Color = Color.RED
    override var debug: Boolean = false
    override val fps: Int = 30
    override val defaultTextFont: Font = Font("Verdana", Font.PLAIN, 25)
    override val title: String = "Magic Mirror"
}
