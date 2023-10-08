package com.trawlbens.hometest.di

import com.trawlbens.hometest.BuildConfig
import com.trawlbens.hometest.data.datasource.MovieDataSource
import com.trawlbens.hometest.data.datasource.MovieDataSourceImpl
import com.trawlbens.hometest.data.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url().newBuilder()
                .build()

            val newRequest = request.newBuilder()
                .url(newUrl)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_AUTH}")
                .build()
            chain.proceed(newRequest)
        }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
    }

    @Singleton
    @Provides
    fun provideAppService(retrofit: Retrofit.Builder): Api {
        return retrofit
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDatasource(movieDataSource: MovieDataSourceImpl): MovieDataSource =
        movieDataSource
}