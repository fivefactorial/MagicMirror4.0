package se.fivefactorial.magicmirror.modules.clock

import se.fivefactorial.magicmirror.mirror.component.ComponentSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.PositionSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings
import java.util.*

data class ClockSettings(
    override var id: String = UUID.randomUUID().toString(),
    override var position: PositionSettings = PositionSettings(100,100),
    override var size: SizeSettings = SizeSettings(200,100)
) : ComponentSettings {
  override val type: String = "clock"
}