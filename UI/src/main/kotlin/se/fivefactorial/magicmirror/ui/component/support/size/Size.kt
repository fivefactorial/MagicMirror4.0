package se.fivefactorial.magicmirror.ui.component.support.size

import java.awt.Dimension

interface Size {
    fun calculate(screenSize: Dimension): Dimension;
}