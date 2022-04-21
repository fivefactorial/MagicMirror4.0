package se.fivefactorial.magicmirror.ui.component.support

import kotlinx.serialization.Serializable

@Serializable
data class Color(
    var red: Int,
    var green: Int,
    var blue: Int,
    var alpha: Int,
)
