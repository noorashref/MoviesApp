package com.example.moviesapp.data.movies

import com.example.moviesapp.api.MoviesApiClient
import com.example.moviesapp.data.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val moviesApiClient: MoviesApiClient,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getPopularMovies(page: Int) = withContext(ioDispatcher) {
        moviesApiClient.getPopularMovies(page)
    }

    suspend fun getMovieDetails(id: Int) = withContext(ioDispatcher) {
        moviesApiClient.getMovieDetails(id)
    }
}
