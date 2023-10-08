package com.trawlbens.hometest.data.datasource

import com.trawlbens.hometest.data.model.MovieDTO
import com.trawlbens.hometest.data.remote.response.BaseResponse
import com.trawlbens.hometest.data.remote.response.MovieListResponse
import com.trawlbens.hometest.data.remote.response.ReviewListResponse

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
interface ApiDataSource {
    suspend fun getPopularMovies(page: Int): BaseResponse<MovieListResponse>
    suspend fun getMovieDetail(movieId: Int): BaseResponse<MovieDTO>
    suspend fun getMovieReviews(movieId: Int): BaseResponse<ReviewListResponse>
}