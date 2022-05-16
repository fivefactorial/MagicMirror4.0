package se.fivefactorial.magicmirror.ui.component.support.position

import java.awt.Dimension
import java.awt.Point

interface Position {
    fun calculate(screenSize: Dimension): Point;
}