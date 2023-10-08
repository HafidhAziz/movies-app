package com.trawlbens.hometest.di

import android.content.Context
import androidx.room.Room
import com.trawlbens.hometest.data.local.FavoriteMovieDao
import com.trawlbens.hometest.data.local.TheMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): TheMovieDatabase {
        return Room.databaseBuilder(
            appContext,
            TheMovieDatabase::class.java,
            TheMovieDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFavoriteMovieDao(database: TheMovieDatabase): FavoriteMovieDao {
        return database.favoriteMovieDao()
    }
}