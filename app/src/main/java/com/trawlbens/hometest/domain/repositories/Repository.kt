package com.trawlbens.hometest.domain.repositories

import com.trawlbens.hometest.util.Resource
import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.domain.model.MovieList
import com.trawlbens.hometest.domain.model.Review
import kotlinx.coroutines.flow.Flow

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
interface Repository {
    suspend fun getPopularMovies(page: Int): MovieList
    suspend fun getMovieDetail(movieId: Int): Flow<Resource<Movie>>
    suspend fun getMovieReviews(movieId: Int): Flow<Resource<List<Review>>>
}