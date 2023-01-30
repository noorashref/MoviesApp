package com.example.moviesapp.domain.repo

import com.example.moviesapp.domain.model.MovieSummary
import com.example.moviesapp.domain.model.MovieDetails

interface MoviesRepository {
    suspend fun fetchPopularMovies(page: Int): Result<List<MovieSummary>>

    suspend fun fetchMovieDetails(id: Int): Result<MovieDetails>
}
