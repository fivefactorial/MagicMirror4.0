package se.fivefactorial.magicmirror.ui.settings

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Color

object DevelopmentSettings : UISettings {
    override val background: Color = Color.WHITE
    override val textColor: Color = Color.BLACK
    override val debugColor: Color = Color.RED
    override var debug: Boolean = false
    override val fps: Int = 30
}