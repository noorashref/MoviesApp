package com.example.moviesapp.api

import com.example.moviesapp.api.responses.ConfigurationResponse
import com.example.moviesapp.api.responses.MovieResponse
import com.example.moviesapp.api.responses.PopularMoviesResponse

interface MoviesApiClient {
    suspend fun getApiConfiguration(): Result<ConfigurationResponse>

    suspend fun getPopularMovies(page: Int): Result<PopularMoviesResponse>

    suspend fun getMovieDetails(id: Int): Result<MovieResponse>
}
