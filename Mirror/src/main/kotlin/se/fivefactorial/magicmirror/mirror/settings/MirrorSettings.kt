package se.fivefactorial.magicmirror.mirror.settings

import kotlinx.serialization.Serializable
import se.fivefactorial.magicmirror.ui.UISettings

@Serializable
data class MirrorSettings(
    var name: String = "Magic Mirror",

    val ui: UISettings = UISettings()
)