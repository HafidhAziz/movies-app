package com.trawlbens.hometest.domain.repositories

import com.trawlbens.hometest.domain.model.MovieList

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MovieList
}