package com.example.moviesapp.domain.repo

import com.example.moviesapp.domain.model.ApiConfiguration

interface ConfigurationRepository {
    suspend fun fetchConfiguration(): Result<ApiConfiguration>
}
