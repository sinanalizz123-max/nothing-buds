package com.nothingbuds.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/** Fallback seed for devices without dynamic color. */
val NothingRed = Color(0xFFD71921)

private val FallbackDark = darkColorScheme(
    primary = Color(0xFFFFB3AE),
    onPrimary = Color(0xFF680010),
    primaryContainer = Color(0xFF93000E),
    onPrimaryContainer = Color(0xFFFFDAD6),
    secondary = Color(0xFFE7BDB9),
    onSecondary = Color(0xFF442927),
    secondaryContainer = Color(0xFF5D3F3C),
    onSecondaryContainer = Color(0xFFFFDAD6),
    tertiary = Color(0xFFE1C38C),
    onTertiary = Color(0xFF402D05),
    surface = Color(0xFF1A1110),
    onSurface = Color(0xFFF1DEDC),
    surfaceVariant = Color(0xFF534341),
    onSurfaceVariant = Color(0xFFD8C2BF),
    outline = Color(0xFFA08C8A),
    outlineVariant = Color(0xFF534341),
)

private val FallbackLight = lightColorScheme(
    primary = Color(0xFF9C4A00),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDCBE),
    onPrimaryContainer = Color(0xFF2F1500),
    secondary = Color(0xFF5F5F5F),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE8E8E8),
    onSecondaryContainer = Color(0xFF1B1B1B),
    tertiary = Color(0xFF7A6A5F),
    onTertiary = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFDFB),
    onSurface = Color(0xFF1F1B16),
    surfaceVariant = Color(0xFFF0EDEA),
    onSurfaceVariant = Color(0xFF4D4540),
    outline = Color(0xFF8A7F78),
    outlineVariant = Color(0xFFE0D8D2),
)

/**
 * Material You: the scheme comes from the user's wallpaper where the platform supports it, and
 * falls back to a Nothing-red seeded scheme elsewhere.
 */
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NothingEarbudsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)

        darkTheme -> FallbackDark
        else -> FallbackLight
    }

    MaterialExpressiveTheme(
        colorScheme = colorScheme,
        // Springy, slightly overshooting transitions — the expressive default.
        motionScheme = MotionScheme.expressive(),
        content = content,
    )
}
