package com.trawlbens.hometest.di

import com.trawlbens.hometest.data.local.FavoriteMovieDataSource
import com.trawlbens.hometest.data.local.FavoriteMovieLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class FavoriteMovieModule {

    @Singleton
    @Binds
    abstract fun bindFavoriteMovie(impl: FavoriteMovieLocalDataSource): FavoriteMovieDataSource
}