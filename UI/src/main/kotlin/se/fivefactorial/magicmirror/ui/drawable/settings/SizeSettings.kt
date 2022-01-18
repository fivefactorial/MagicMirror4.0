package se.fivefactorial.magicmirror.ui.drawable.settings

import java.awt.Dimension

data class SizeSettings(
    val width: Int,
    val height: Int
) {
    fun toDimension() = Dimension(width, height)
}