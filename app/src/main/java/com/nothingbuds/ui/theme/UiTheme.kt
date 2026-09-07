package com.nothingbuds.ui.theme

enum class UiTheme(val label: String) {
    MATERIAL_DARK("Material3 Dark"),
    MATERIAL_LIGHT("Material3 Light"),
    LIQUID_GLASS("Liquid Glass");

    companion object {
        const val PREF_KEY = "ui_theme"

        fun parse(raw: String?): UiTheme =
            try {
                valueOf(raw ?: "")
            } catch (_: Exception) {
                LIQUID_GLASS
            }
    }
}
