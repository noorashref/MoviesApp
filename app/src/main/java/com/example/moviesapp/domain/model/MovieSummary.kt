package com.example.moviesapp.domain.model

import java.util.*

data class MovieSummary(val id: Int,
                        val title: String,
                        val rating: Float,
                        val releaseDate: Date,
                        val imageUrl: String)
