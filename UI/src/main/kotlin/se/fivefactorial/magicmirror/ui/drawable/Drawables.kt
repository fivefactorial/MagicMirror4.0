package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.drawable.settings.PositionSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.SizeSettings
import se.fivefactorial.magicmirror.ui.drawable.settings.TextSettings

fun text(
    textSettings: TextSettings = TextSettings(),
    text: () -> String?
): Text = Text(textSettings) { text() ?: "" }

fun text(
    textSettings: TextSettings = TextSettings(),
    text: String
): Text = Text(textSettings) { text }

fun container(vararg children: Drawable) = Group(*children)

fun center(child: Drawable) = Center(child)

fun absolute(child: Drawable, positionSettings: PositionSettings, sizeSettings: SizeSettings) =
    Absolute(child, positionSettings, sizeSettings)

fun stack(vararg children: Drawable) = Stack(*children)

fun circularSpinner(size: Int = 50) = CircularSpinner(size)

fun group() = Group()