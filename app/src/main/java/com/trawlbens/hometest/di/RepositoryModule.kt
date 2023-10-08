package com.trawlbens.hometest.di

import com.trawlbens.hometest.domain.repositories.Repository
import com.trawlbens.hometest.domain.repositories.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideApiRepository(movieRepositoryImpl: RepositoryImpl): Repository =
        movieRepositoryImpl
}