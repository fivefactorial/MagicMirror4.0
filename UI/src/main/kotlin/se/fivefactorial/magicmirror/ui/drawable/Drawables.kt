package se.fivefactorial.magicmirror.ui.drawable

import se.fivefactorial.magicmirror.ui.drawable.settings.TextSettings

fun text(
    textSettings: TextSettings = TextSettings(),
    text: () -> String
): Text = Text(textSettings, text)

fun text(
    textSettings: TextSettings = TextSettings(),
    text: String
): Text = Text(textSettings) { text }

fun container(vararg children: Drawable) = Group(*children)

fun center(child: Drawable) = Center(child)
