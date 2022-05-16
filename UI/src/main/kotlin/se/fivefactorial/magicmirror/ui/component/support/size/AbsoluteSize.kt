package se.fivefactorial.magicmirror.ui.component.support.size

import java.awt.Dimension

class AbsoluteSize(private val size: Dimension) : Size {

    constructor(width: Int, height: Int) : this(Dimension(width, height))

    override fun calculate(screenSize: Dimension) = size
}