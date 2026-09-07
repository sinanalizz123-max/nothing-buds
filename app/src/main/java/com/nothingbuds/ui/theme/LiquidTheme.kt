package com.nothingbuds.ui.theme

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.kyant.backdrop.backdrops.LayerBackdrop
import com.kyant.backdrop.backdrops.layerBackdrop
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.colorControls
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy

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
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF0B0710), Color(0xFF050508), Color(0xFF0A0612))
            )
        )
        drawCircle(
            Color(0x40FF7135),
            radius = w * 0.38f,
            center = Offset(w * 0.12f, h * 0.16f)
        )
        drawCircle(
            Color(0x335E5CE6),
            radius = w * 0.38f,
            center = Offset(w * 0.88f, h * 0.82f)
        )
        drawCircle(
            Color(0x1FB14AED),
            radius = w * 0.3f,
            center = Offset(w * 0.55f, h * 0.5f)
        )
    }
}

/**
 * Backdrop every liquid-glass surface on a screen samples from.
 * Glass surfaces must be SIBLINGS of the source node carrying
 * [appBackdropSource], never its descendants (render-feedback loop).
 */
val LocalAppBackdrop = compositionLocalOf<LayerBackdrop?> { null }

@Composable
fun rememberAppBackdrop(): LayerBackdrop = rememberLayerBackdrop {
    drawRect(Color(0xFF050508))
    drawContent()
}

fun Modifier.appBackdropSource(backdrop: LayerBackdrop): Modifier =
    this.layerBackdrop(backdrop)

/**
 * Real backdrop-refraction glass modeled on SimpMusic's liquid-glass primitive:
 * vibrancy + neutral color controls + luminance blur + lens refraction, finished
 * with a dark scrim so content stays legible.
 */
fun Modifier.liquidGlass(
    backdrop: LayerBackdrop,
    shape: Shape,
    scrim: Color = Color.Black.copy(alpha = 0.28f),
): Modifier = this.drawBackdrop(
    backdrop = backdrop,
    shape = { shape },
    effects = {
        vibrancy()
        colorControls(
            brightness = 0.05f,
            contrast = 1f,
            saturation = 1.5f,
        )
        blur(12.dp.toPx())
        lens(size.minDimension / 4f, size.minDimension / 2f, false)
    },
    onDrawSurface = {
        drawRect(scrim)
    },
)

/**
 * Screen root: records the ambient background into a shared backdrop layer and
 * provides it to glass descendants. Content must NOT draw the background itself
 * (it is already in the recorded layer).
 */
@Composable
fun GlassScreenRoot(content: @Composable () -> Unit) {
    val backdrop = rememberAppBackdrop()
    CompositionLocalProvider(LocalAppBackdrop provides backdrop) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .appBackdropSource(backdrop)
            ) {
                AmbientBackground()
            }
            content()
        }
    }
}
