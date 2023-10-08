package com.trawlbens.hometest.data.datasource

import com.trawlbens.hometest.data.model.MovieDTO
import com.trawlbens.hometest.data.remote.Api
import com.trawlbens.hometest.data.remote.BaseApi
import com.trawlbens.hometest.data.remote.response.BaseResponse
import com.trawlbens.hometest.data.remote.response.MovieListResponse
import com.trawlbens.hometest.data.remote.response.ReviewListResponse
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class ApiDataSourceImpl @Inject constructor(private val api: Api) :
    ApiDataSource, BaseApi() {

    override suspend fun getPopularMovies(page: Int): BaseResponse<MovieListResponse> {
        return createCall { api.getPopularMovies(page, true) }
    }

    override suspend fun getMovieDetail(movieId: Int): BaseResponse<MovieDTO> {
        return createCall { api.getMovieDetail(movieId) }
    }

    override suspend fun getMovieReviews(movieId: Int): BaseResponse<ReviewListResponse> {
        return createCall { api.getMovieReviews(movieId) }
    }
}