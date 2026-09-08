package com.nothingbuds.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyant.backdrop.backdrops.LayerBackdrop
import com.nothingbuds.ui.theme.LiquidTheme
import com.nothingbuds.ui.theme.LocalAppBackdrop
import com.nothingbuds.ui.theme.LocalGlassEnabled
import com.nothingbuds.ui.theme.liquidGlass
import kotlin.math.roundToInt

@Composable
fun LiquidToggle(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    backdrop: LayerBackdrop? = LocalAppBackdrop.current,
) {
    if (!LocalGlassEnabled.current) {
        androidx.compose.material3.Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        return
    }
    val thumbX by animateFloatAsState(
        targetValue = if (checked) 1f else 0f,
        animationSpec = LiquidTheme.SpringSpec,
        label = "thumb"
    )
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val pressScale by animateFloatAsState(
        targetValue = if (pressed) 1.06f else 1f,
        animationSpec = LiquidTheme.SpringSpec,
        label = "press"
    )
    Box(
        modifier = Modifier
            .size(52.dp, 32.dp)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .then(
                if (backdrop != null) Modifier.liquidGlass(backdrop, CircleShape)
                else Modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0x14FFFFFF), Color(0x06FFFFFF))
                    ),
                    shape = LiquidTheme.PillShape
                )
            )
            .then(
                if (checked) Modifier.background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            LiquidTheme.Accent.copy(alpha = 0.85f),
                            Color(0xBEFF5B2A)
                        )
                    ),
                    shape = LiquidTheme.PillShape
                ) else Modifier
            )
            .border(
                1.dp,
                if (checked) Color(0x66FFA680) else LiquidTheme.GlassBorder,
                LiquidTheme.PillShape
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onCheckedChange(!checked) }
            )
            .padding(3.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .offset {
                    IntOffset(((20.dp.roundToPx() * thumbX).roundToInt()), 0)
                }
        ) {
            val r = size.minDimension / 2
            drawCircle(Color(0x59000000), radius = r, center = Offset(r, r + 4f))
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.White, Color(0xFFF2F2F7), Color(0xFFD1D1D6)),
                    center = Offset(r * 0.7f, r * 0.7f),
                    radius = r
                ),
                radius = r,
                center = Offset(r, r)
            )
            drawOval(
                Color(0xE6FFFFFF),
                topLeft = Offset(r * 0.35f, r * 0.2f),
                size = Size(r * 0.6f, r * 0.3f)
            )
        }
    }
}

@Composable
fun LiquidGlassTabBar(
    options: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    backdrop: LayerBackdrop? = LocalAppBackdrop.current,
    modifier: Modifier = Modifier,
) {
    val capsuleShape = androidx.compose.foundation.shape.RoundedCornerShape(percent = 50)
    if (!LocalGlassEnabled.current) {
        SingleChoiceSegmentedButtonRow(
            modifier = modifier.fillMaxWidth()
        ) {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    selected = selectedIndex == index,
                    onClick = { onSelect(index) },
                    shape = SegmentedButtonDefaults.itemShape(
                        index, options.size
                    ),
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = MaterialTheme.colorScheme.primary,
                        activeContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    icon = {},
                ) {
                    Text(label)
                }
            }
        }
        return
    }
    val indicatorFraction by animateFloatAsState(
        targetValue = selectedIndex.toFloat(),
        animationSpec = LiquidTheme.SpringSpec,
        label = "tabIndicator"
    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (backdrop != null) Modifier.liquidGlass(backdrop, capsuleShape)
                else Modifier
                    .background(Color(0x0AFFFFFF), capsuleShape)
                    .border(1.dp, LiquidTheme.GlassBorder, capsuleShape)
            )
            .padding(4.dp)
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val segW = maxWidth / options.size
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Box(
                    modifier = Modifier
                        .width(segW)
                        .fillMaxHeight()
                        .graphicsLayer {
                            translationX = segW.toPx() * indicatorFraction
                        }
                        .then(
                            if (backdrop != null) Modifier.liquidGlass(
                                backdrop = backdrop,
                                shape = capsuleShape,
                                scrim = Color.White.copy(alpha = 0.1f)
                            )
                            else Modifier.background(Color(0x1FFFFFFF), capsuleShape)
                        )
                        .border(1.dp, Color(0x33FFFFFF), capsuleShape)
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    options.forEachIndexed { index, label ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(capsuleShape)
                                .clickable { onSelect(index) }
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (selectedIndex == index) Color.White else LiquidTheme.TextSub,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GlassButton(
    text: String,
    primary: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(LiquidTheme.PillShape)
            .background(if (primary) LiquidTheme.Accent else Color(0x0AFFFFFF))
            .border(
                1.dp,
                if (primary) LiquidTheme.Accent else LiquidTheme.GlassBorder,
                LiquidTheme.PillShape
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 22.dp, vertical = 10.dp)
    ) {
        Text(
            text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (primary) Color.White else LiquidTheme.TextMain
        )
    }
}

@Composable
fun ProgressRing(
    progress: Float,
    centerText: String,
    unit: String,
    doneColor: Color? = null,
    modifier: Modifier = Modifier
) {
    val color = doneColor ?: LiquidTheme.Accent
    Box(contentAlignment = Alignment.Center, modifier = modifier.size(120.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke = 6.dp.toPx()
            val arcSize = size.minDimension - stroke
            val topLeft = Offset(stroke / 2, stroke / 2)
            drawArc(
                Color(0x14FFFFFF), 0f, 360f, false, topLeft,
                Size(arcSize, arcSize), style = Stroke(stroke)
            )
            drawArc(
                color, -90f, progress * 360f, false, topLeft,
                Size(arcSize, arcSize), style = Stroke(stroke)
            )
            if (progress > 0f && doneColor == null) {
                drawArc(
                    color.copy(alpha = 0.3f), -90f, progress * 360f, false,
                    topLeft, Size(arcSize, arcSize),
                    style = Stroke(stroke * 3), blendMode = androidx.compose.ui.graphics.BlendMode.Screen
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                centerText,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = LiquidTheme.TextMain
            )
            if (unit.isNotEmpty()) {
                Text(
                    unit,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = LiquidTheme.TextSub
                )
            }
        }
    }
}

@Composable
fun EqDragSlider(
    value: Int,
    onValueChange: (Int) -> Unit,
    onValueChangeFinished: () -> Unit
) {
    var dragging by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "${if (value > 0) "+" else ""}$value",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (value != 0) LiquidTheme.Accent else LiquidTheme.TextSub
        )
        BoxWithConstraints(
            modifier = Modifier
                .width(52.dp)
                .height(200.dp)
        ) {
            val trackH = maxHeight
            val half = trackH / 2
            val fillH = half * kotlin.math.abs(value) / 6f
            val density = androidx.compose.ui.platform.LocalDensity.current
            val trackHPx = with(density) { trackH.roundToPx() }

            fun valueForY(yPx: Float): Int {
                val ratio = 1f - (yPx / trackHPx.toFloat()).coerceIn(0f, 1f)
                return (-6f + ratio * 12f).roundToInt().coerceIn(-6, 6)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectVerticalDragGestures(
                            onDragStart = { offset ->
                                dragging = true
                                onValueChange(valueForY(offset.y))
                            },
                            onDragEnd = {
                                dragging = false
                                onValueChangeFinished()
                            },
                            onDragCancel = { dragging = false },
                            onVerticalDrag = { change, _ ->
                                change.consume()
                                onValueChange(valueForY(change.position.y))
                            }
                        )
                    }
            ) {
                Box(
                    modifier = Modifier
                        .width(4.dp)
                        .fillMaxHeight()
                        .padding(vertical = 14.dp)
                        .align(Alignment.Center)
                        .background(Color(0x14FFFFFF), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .width(22.dp)
                        .height(2.dp)
                        .align(Alignment.Center)
                        .background(Color(0x40FFFFFF), CircleShape)
                )
                if (value != 0) {
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(fillH)
                            .align(if (value > 0) Alignment.TopCenter else Alignment.BottomCenter)
                            .offset(y = if (value > 0) half - fillH else -(half - fillH))
                            .background(LiquidTheme.Accent, CircleShape)
                    )
                }
                val ratio = (value + 6) / 12f
                Box(
                    modifier = Modifier
                        .size(if (dragging) 32.dp else 26.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = trackH * (1f - ratio) - (if (dragging) 16.dp else 13.dp))
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color.White, Color(0xFFF2F2F7), Color(0xFFD1D1D6))
                            ),
                            shape = CircleShape
                        )
                        .border(1.dp, Color(0x1AFFFFFF), CircleShape)
                )
            }
        }
    }
}
