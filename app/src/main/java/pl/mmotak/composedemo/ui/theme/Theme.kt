package pl.mmotak.composedemo.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat



//private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200,
//
//    background = Color.White,
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//)
//
//private val LightColorPalette = lightColors(
//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200,
//
//    background = Color.White,
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onBackground = Color.Black,
//    onSurface = Color.Black,
//
//)

@SuppressLint("ConflictingOnColor")
private val DarkColorPaletteA = darkColors(//darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    error = ErrorDark,
    onError = OnErrorDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,

//    primaryContainer = PrimaryContainerDark,
//    onPrimaryContainer = OnPrimaryContainerDark,
//    secondaryContainer = SecondaryContainerDark,
//    onSecondaryContainer = OnSecondaryContainerDark,
//    tertiary = TertiaryDark,
//    onTertiary = OnTertiaryDark,
//    tertiaryContainer = TertiaryContainerDark,
//    onTertiaryContainer = OnTertiaryContainerDark,
//    errorContainer = ErrorContainerDark,
//    onErrorContainer = OnErrorContainerDark,
//    outline = OutlineDark,
//    surfaceVariant = SurfaceVariantDark,
//    onSurfaceVariant = OnSurfaceVariantDark,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPaletteB = lightColors( //lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,

    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,

    error = ErrorLight,
    onError = OnErrorLight,

    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,


//    primaryContainer = PrimaryContainerLight,
//    onPrimaryContainer = OnPrimaryContainerLight,
//    secondaryContainer = SecondaryContainerLight,
//    onSecondaryContainer = OnSecondaryContainerLight,
//    tertiary = TertiaryLight,
//    onTertiary = OnTertiaryLight,
//    tertiaryContainer = TertiaryContainerLight,
//    onTertiaryContainer = OnTertiaryContainerLight,
//    errorContainer = ErrorContainerLight,
//    onErrorContainer = OnErrorContainerLight,
//    outline = OutlineLight,
//    surfaceVariant = SurfaceVariantLight,
//    onSurfaceVariant = OnSurfaceVariantLight,
)

enum class MyPalette(
    DarkColorPalette: Colors,
    LightColorPalette: Colors
) {
    CustomA(
        DarkColorPaletteA,
        LightColorPaletteB,
    ) // https://itnext.io/dark-theme-in-jetpack-compose-with-material-3-757e45118259
}

@Composable
fun ComposeDemoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPaletteA
    } else {
        LightColorPaletteB
    }

    MaterialTheme(
        colors  = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    // Optional, this part helps you set the statusbar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.background.toArgb()

            WindowCompat.getInsetsController(window, view)
                ?.isAppearanceLightStatusBars = !darkTheme
        }
    }
}