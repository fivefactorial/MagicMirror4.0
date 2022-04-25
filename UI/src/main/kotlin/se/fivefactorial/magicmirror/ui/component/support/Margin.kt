package se.fivefactorial.magicmirror.ui.component.support

import kotlinx.serialization.Serializable

@Serializable
data class Margin(
    val left: Int,
    val right: Int,
    val top: Int,
    val bottom: Int
) {
    companion object {
        val NO_MARGIN = Margin(0, 0, 0, 0)
    }

    constructor(margin: Int) : this(margin, margin, margin, margin)
}
