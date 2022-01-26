package se.fivefactorial.magicmirror.mirror.settings

import kotlinx.serialization.Serializable

@Serializable
data class MirrorSettings(
    var name: String = "Magic Mirror"
)