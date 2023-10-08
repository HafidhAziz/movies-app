package com.trawlbens.hometest.data.datasource

import com.trawlbens.hometest.data.remote.response.BaseResponse
import com.trawlbens.hometest.data.remote.response.MovieListResponse

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
interface MovieDataSource {
    suspend fun fetchPopularMovies(page: Int): BaseResponse<MovieListResponse>
}