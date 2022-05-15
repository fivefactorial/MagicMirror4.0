package se.fivefactorial.magicmirror.ui.component

import se.fivefactorial.magicmirror.ui.UISettings
import java.awt.Graphics2D

class ComponentCollection : Component() {

    private val components = mutableListOf<Component>()

    override fun setup(settings: UISettings) {
        super.setup(settings)
        components.forEach { it.setup(settings) }
    }

    override fun draw(g: Graphics2D) {
        components.forEach {
            it.size = size
            g.drawImage(it.draw(), 0, 0, null)
        }
    }

    fun add(component: Component) {
        components.add(component)
    }
}