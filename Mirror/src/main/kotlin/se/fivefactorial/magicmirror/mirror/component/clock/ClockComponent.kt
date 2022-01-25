package se.fivefactorial.magicmirror.mirror.component.clock

import se.fivefactorial.magicmirror.mirror.component.Component
import se.fivefactorial.magicmirror.mirror.component.clock.ClockSettings
import se.fivefactorial.magicmirror.ui.drawable.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ClockComponent(settings: ClockSettings = ClockSettings()) : Component<ClockSettings>(settings) {

    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss")

    private val time: String
        get() {
            return timeFormat.format(LocalDateTime.now())
        }

    override fun setup() {
        val timeComponent = center(text { time })
        val dateComponent = center(text { "Some date" })
        container.add(stack(timeComponent, dateComponent))
    }

}