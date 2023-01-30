package com.example.moviesapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.utils.DateFormatter
import com.example.moviesapp.utils.TimeFormatter
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MoviesApp() {
    val useDarkTheme = isSystemInDarkTheme()

    MoviesAppFoundation(useDarkTheme = useDarkTheme) {
        val systemUiController = rememberSystemUiController()
        //make sure the system bars match the current theme
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !useDarkTheme)
        }

        Row(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .statusBarsPadding()
                .windowInsetsPadding(
                    WindowInsets
                        .navigationBars
                        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                )
        ) {
            MoviesNavGraph()
        }
    }

}

@Composable
fun MoviesAppFoundation(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    CompositionLocalProvider(
        LocalDateFormatter provides DateFormatter,
        LocalTimeFormatter provides TimeFormatter
    ) {
        MoviesAppTheme(useDarkTheme, content = content)
    }
}
