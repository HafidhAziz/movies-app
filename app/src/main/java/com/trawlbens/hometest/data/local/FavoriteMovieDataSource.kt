package com.trawlbens.hometest.data.local

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
interface FavoriteMovieDataSource {
    fun getAllFavoriteMovies(callback: (List<FavoriteMovie>) -> Unit)
    fun addMovie(
        idMovie: Int,
        imageUrl: String,
        title: String,
        releaseDate: String,
        overview: String
    )

    fun isItemExists(id: Int, callback: (Boolean) -> Unit)

    fun deleteItemById(id: Int)
}