package com.example.moviesapp.data.di

import com.example.moviesapp.data.configuration.ConfigurationRemoteDataSource
import com.example.moviesapp.domain.repo.ConfigurationRepository
import com.example.moviesapp.data.configuration.ConfigurationRepositoryImpl
import com.example.moviesapp.data.movies.MoviesRemoteDataSource
import com.example.moviesapp.domain.repo.MoviesRepository
import com.example.moviesapp.data.movies.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun provideMoviesRepository(
        moviesRemoteDataSource: MoviesRemoteDataSource,
        configurationRepository: ConfigurationRepository
    ): MoviesRepository =
        MoviesRepositoryImpl(moviesRemoteDataSource, configurationRepository)

    @Provides
    fun provideConfigurationRepository(
        configurationRemoteDataSource: ConfigurationRemoteDataSource
    ): ConfigurationRepository =
        ConfigurationRepositoryImpl(configurationRemoteDataSource)
}
