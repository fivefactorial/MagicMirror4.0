package se.fivefactorial.magicmirror.ui.drawable.settings

import java.awt.Point

data class PositionSettings(
    val x: Int,
    val y: Int
) {
    fun toPoint() = Point(x, y)
}