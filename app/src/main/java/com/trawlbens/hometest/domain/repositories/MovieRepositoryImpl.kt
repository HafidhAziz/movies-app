package com.trawlbens.hometest.domain.repositories

import com.trawlbens.hometest.data.datasource.MovieDataSourceImpl
import com.trawlbens.hometest.domain.mapper.MovieListMapper
import com.trawlbens.hometest.domain.model.MovieList
import com.trawlbens.hometest.data.remote.response.BaseResponse
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class MovieRepositoryImpl @Inject constructor(
    private val dataSourceImpl: MovieDataSourceImpl
) : MovieRepository {

    override suspend fun getPopularMovies(page: Int): MovieList {
        return when (val result = dataSourceImpl.fetchPopularMovies(page)) {
            is BaseResponse.Success -> {
                MovieListMapper().map(result.data)
            }

            is BaseResponse.Error -> throw result.error
        }
    }
}
