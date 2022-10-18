package `in`.vivek.interior.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = colorWhite,
    primaryVariant = colorWhite,
    secondary = colorgreeen
)


@Composable
fun FurtureTheme(content: @Composable () -> Unit) {
        LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}