package com.trawlbens.hometest.data.datasource

import com.trawlbens.hometest.data.remote.Api
import com.trawlbens.hometest.data.remote.BaseApi
import com.trawlbens.hometest.data.remote.response.BaseResponse
import com.trawlbens.hometest.data.remote.response.MovieListResponse
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class MovieDataSourceImpl @Inject constructor(private val api: Api) :
    MovieDataSource, BaseApi() {

    override suspend fun fetchPopularMovies(page: Int): BaseResponse<MovieListResponse> {
        return createCall { api.getPopularMovies(page, true) }
    }
}