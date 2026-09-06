package com.nothingbuds.ui.theme

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Liquid Glass design tokens converted from the approved HTML mockup
 * (/storage/emulated/0/opencode/nada/ui-mockup/ui5.html, see readui.md).
 * Pure styling — no behavior or protocol impact.
 */
object LiquidTheme {
    val Accent = Color(0xFFFF7135)
    val AccentGlow = Color(0x66FF7135)
    val TextMain = Color(0xFFF5F5F5)
    val TextSub = Color(0xFF8C8C8E)
    val GlassBg = Color(0x0AFFFFFF)
    val GlassBorder = Color(0x1FFFFFFF)
    val GlassHighlight = Color(0x40FFFFFF)
    val Success = Color(0xFF34C759)
    val DialogBg = Color(0xCC19191E)

    val CardShape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp)
    val PillShape = androidx.compose.foundation.shape.CircleShape

    val SpringSpec = spring<Float>(dampingRatio = 0.65f, stiffness = 350f)
    val SmoothSpec = tween<Float>(durationMillis = 450, easing = FastOutSlowInEasing)
}

/** Specular top highlight drawn over card content, matching the mockup. */
fun Modifier.glassCard(): Modifier = this
    .drawWithContent {
        drawContent()
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(LiquidTheme.GlassHighlight, Color.Transparent),
                startY = 0f,
                endY = size.height * 0.45f
            ),
            blendMode = BlendMode.SrcAtop
        )
    }

@Composable
fun AmbientBackground(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .blur(60.dp)
    ) {
        val w = size.width
        val h = size.height
        drawCircle(
            Color(0x26FF7135),
            radius = w * 0.35f,
            center = Offset(w * 0.15f, h * 0.2f)
        )
        drawCircle(
            Color(0x1F5E5CE6),
            radius = w * 0.35f,
            center = Offset(w * 0.85f, h * 0.8f)
        )
    }
}
