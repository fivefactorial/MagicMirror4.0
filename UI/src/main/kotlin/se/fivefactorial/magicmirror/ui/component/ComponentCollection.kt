package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.UISettings
import se.fivefactorial.magicmirror.ui.component.support.position.AbsolutePosition
import se.fivefactorial.magicmirror.ui.component.support.position.Position
import se.fivefactorial.magicmirror.ui.component.support.size.MaxSize
import se.fivefactorial.magicmirror.ui.component.support.size.Size
import java.awt.Graphics2D
import java.awt.Image
import java.awt.Point

class ComponentCollection : Component() {

    private val components = mutableListOf<Triple<Component, Position, Size>>()

    override fun setup(settings: UISettings) {
        super.setup(settings)
        components.forEach { (component, _, _) -> component.setup(settings) }
    }

    override fun draw(g: Graphics2D) {
        components.forEach { (component, position, componentSize) ->
            component.size = componentSize.calculate(size)
            g.drawImage(component.draw(), position.calculate(size))
        }
    }

    fun add(
        component: Component,
        position: Position = AbsolutePosition(Point(0, 0)),
        size: Size = MaxSize()
    ) {
        components.add(Triple(component, position, size))
    }

    private fun Graphics2D.drawImage(img: Image, position: Point) =
        drawImage(img, position.x, position.y, null)
}