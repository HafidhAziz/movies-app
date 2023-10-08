package com.trawlbens.hometest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@Entity(tableName = "tb_favorite_movies")
data class FavoriteMovie(
    val idMovie: Int,
    val imageUrl: String,
    val title: String,
    val releaseDate: String,
    val overview: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}