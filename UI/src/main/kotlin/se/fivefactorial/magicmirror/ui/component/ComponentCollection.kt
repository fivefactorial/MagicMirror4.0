package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.component.support.AbsolutePosition
import se.fivefactorial.magicmirror.ui.component.support.Position
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Image
import java.awt.Point

class ComponentCollection : Component() {

    private val components = mutableListOf<Pair<Component, Position>>()

    override fun setup(settings: UISettings) {
        super.setup(settings)
        components.forEach { (component, _) -> component.setup(settings) }
    }

    override fun draw(g: Graphics2D) {
        components.forEach { (component, position) ->
            component.size = size
            g.drawImage(component.draw(), position.calculate(size))
        }
    }

    fun add(component: Component, position: Position = AbsolutePosition(Point(0, 0))) {
        components.add(Pair(component, position))
    }

    private fun Graphics2D.drawImage(img: Image, position: Point) =
        drawImage(img, position.x, position.y, null)
}