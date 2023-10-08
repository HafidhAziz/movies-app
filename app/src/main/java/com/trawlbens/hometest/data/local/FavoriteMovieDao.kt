package com.trawlbens.hometest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.trawlbens.hometest.data.local.FavoriteMovie

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@Dao
interface FavoriteMovieDao {

    @Query("SELECT * FROM tb_favorite_movies ORDER BY id DESC")
    fun getAll(): List<FavoriteMovie>

    @Insert
    fun insert(vararg movie: FavoriteMovie)

    @Query("SELECT EXISTS (SELECT 1 FROM tb_favorite_movies WHERE idMovie = :id)")
    fun isItemExists(id: Int): Boolean

    @Query("DELETE FROM tb_favorite_movies WHERE idMovie = :id")
    fun deleteItemById(id: Int)

}