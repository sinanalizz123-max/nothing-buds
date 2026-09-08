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
                MATERIAL_DARK
            }

        /** First-launch default: Material3 following the system theme. */
        fun systemDefault(isSystemDark: Boolean): UiTheme =
            if (isSystemDark) MATERIAL_DARK else MATERIAL_LIGHT
    }
}
