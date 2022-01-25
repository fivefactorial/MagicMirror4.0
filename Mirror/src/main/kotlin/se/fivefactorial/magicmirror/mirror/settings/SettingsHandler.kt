package se.fivefactorial.magicmirror.mirror.settings

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.net.URL


class SettingsHandler {


    fun load(): MirrorSettings {

        val resourceFetcher: (String) -> URL? = if (hasResourcesFolder()) {
            { urlFromResource(it) }
        } else {
            { urlFromPath(it) }
        }

        val resource: URL = resourceFetcher("settings.json")
            ?: throw SettingsException("Settings file not found")

        val data: String = resource.readText(Charsets.ISO_8859_1)
        val settings = Json { ignoreUnknownKeys = true }.decodeFromString<MirrorSettings>(data)
        return settings
    }

    private fun urlFromResource(filename: String): URL? = this.javaClass.classLoader.getResource(filename)

    private fun urlFromPath(filename: String): URL? =
        File(filename).apply { if (!exists()) return null }.toURI().toURL()

    private fun hasResourcesFolder(): Boolean = this.javaClass.classLoader.getResource(".") != null
}