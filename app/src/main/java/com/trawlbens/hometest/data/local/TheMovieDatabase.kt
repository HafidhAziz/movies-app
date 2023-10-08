package com.trawlbens.hometest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@Database(entities = [FavoriteMovie::class], version = 1, exportSchema = false)
abstract class TheMovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao

    companion object {
        const val DATABASE_NAME: String = "the_movie.db"
    }
}