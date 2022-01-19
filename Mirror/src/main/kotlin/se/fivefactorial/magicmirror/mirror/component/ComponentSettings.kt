package se.fivefactorial.magicmirror.mirror.component

import se.fivefactorial.magicmirror.ui.drawable.settings.PositionSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings

interface ComponentSettings {
    var id: String
    val type: String
    var position: PositionSettings
    var size: SizeSettings
}