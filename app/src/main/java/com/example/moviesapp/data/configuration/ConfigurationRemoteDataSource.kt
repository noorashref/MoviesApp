package com.example.moviesapp.data.configuration

import com.example.moviesapp.api.MoviesApiClient
import com.example.moviesapp.data.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ConfigurationRemoteDataSource @Inject constructor(
    private val moviesApiClient: MoviesApiClient,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun getApiConfiguration() = withContext(ioDispatcher) {
        moviesApiClient.getApiConfiguration()
    }
}
