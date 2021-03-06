package se.fivefactorial.magicmirror.mirror.settings

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.net.URL

object SettingsHandler {

    private val textCharset = Charsets.ISO_8859_1

    private val json by lazy { Json { ignoreUnknownKeys = true } }

    /**
     * Loads the given filename and parses it to MirrorSettings
     */
    fun load(filename: String): MirrorSettings {
        val resourceFetcher: (String) -> URL? = if (hasResourcesFolder()) {
            { urlFromResource(it) }
        } else {
            { urlFromPath(it) }
        }

        val resource: URL = resourceFetcher(filename)
            ?: throw SettingsException("Settings file ($filename) not found")

        val data: String = resource.readText(textCharset)
        return json.decodeFromString(data)
    }

    private fun urlFromResource(filename: String): URL? = this.javaClass.classLoader.getResource(filename)

    private fun urlFromPath(filename: String): URL? =
        File(filename).apply { if (!exists()) return null }.toURI().toURL()

    private fun hasResourcesFolder(): Boolean = this.javaClass.classLoader.getResource(".") != null
}