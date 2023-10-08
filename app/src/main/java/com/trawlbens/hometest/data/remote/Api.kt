package com.trawlbens.hometest.data.remote

import com.trawlbens.hometest.data.model.MovieDTO
import com.trawlbens.hometest.data.remote.response.MovieListResponse
import com.trawlbens.hometest.data.remote.response.ReviewListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
interface Api {

    @GET("3/discover/movie?sort_by=vote_count.desc")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("include_adult") includeAdult: Boolean,
    ) : Response<MovieListResponse>

    @GET("3/movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
    ): Response<MovieDTO>

    @GET("3/movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int,
    ): Response<ReviewListResponse>
}