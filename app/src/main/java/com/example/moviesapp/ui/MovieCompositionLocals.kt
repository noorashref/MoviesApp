package com.example.moviesapp.ui

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.moviesapp.utils.DateFormatter
import com.example.moviesapp.utils.TimeFormatter


val LocalDateFormatter = staticCompositionLocalOf<DateFormatter> {
    error("DateFormatter not provided")
}

val LocalTimeFormatter = staticCompositionLocalOf<TimeFormatter> {
    error("TimeFormatter not provided")
}
