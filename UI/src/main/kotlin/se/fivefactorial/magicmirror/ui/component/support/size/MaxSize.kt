package se.fivefactorial.magicmirror.ui.component.support.size

import java.awt.Dimension

class MaxSize : Size {
    override fun calculate(screenSize: Dimension) = screenSize
}