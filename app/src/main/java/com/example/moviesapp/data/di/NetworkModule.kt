package com.example.moviesapp.data.di


import com.example.moviesapp.BuildConfig
import com.example.moviesapp.api.MoviesApiClient
import com.example.moviesapp.api.retrofit.TMDbClient
import com.example.moviesapp.api.retrofit.adapters.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): MoviesApiClient {
        return retrofit.create(TMDbClient::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @BaseUrl baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClient(@ApiKey apiKey: String) =
        OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest: Request = chain.request()
            val originalHttpUrl: HttpUrl = originalRequest.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY_QUERY_PARAM_NAME, apiKey)
                .build()

            chain.proceed(originalRequest.newBuilder().url(url).build())
        }.addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        ).build()

    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl() = TMDB_API_URL

    @Provides
    @Singleton
    @ApiKey
    fun provideApiKey() = TMDB_API_KEY

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class BaseUrl

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class ApiKey

    companion object {
        const val API_KEY_QUERY_PARAM_NAME = "api_key"
        const val TMDB_API_KEY = "cb36ac718db0df223addf7b14f15f7f0"
        const val TMDB_API_URL = "https://api.themoviedb.org/3/"
    }
}
