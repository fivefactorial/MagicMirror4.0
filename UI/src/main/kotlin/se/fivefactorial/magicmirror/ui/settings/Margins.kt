package se.fivefactorial.magicmirror.ui.settings

import kotlinx.serialization.Serializable

@Serializable
data class Margins(
    val left: Int,
    val right: Int,
    val top: Int,
    val bottom: Int
)
