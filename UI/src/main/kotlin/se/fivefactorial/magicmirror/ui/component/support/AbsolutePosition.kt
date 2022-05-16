package se.fivefactorial.magicmirror.ui.component.support

import java.awt.Dimension
import java.awt.Point

class AbsolutePosition(private val position: Point) : Position {

    constructor(x: Int, y: Int): this(Point(x,y))

    override fun calculate(screenSize: Dimension): Point {
        return position;
    }
}