package se.fivefactorial.magicmirror.mirror.settings

import kotlinx.serialization.Serializable

@Serializable
data class MirrorSettings(
    var test: String,
    var test2: String = "no"
)