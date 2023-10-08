package com.trawlbens.hometest.domain.repositories

import com.trawlbens.hometest.util.Resource
import com.trawlbens.hometest.data.datasource.ApiDataSourceImpl
import com.trawlbens.hometest.data.remote.response.BaseResponse
import com.trawlbens.hometest.domain.mapper.MovieDetailMapper
import com.trawlbens.hometest.domain.mapper.MovieListMapper
import com.trawlbens.hometest.domain.mapper.ReviewListMapper
import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.domain.model.MovieList
import com.trawlbens.hometest.domain.model.Review
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class RepositoryImpl @Inject constructor(
    private val dataSourceImpl: ApiDataSourceImpl
) : Repository {

    override suspend fun getPopularMovies(page: Int): MovieList {
        return when (val result = dataSourceImpl.getPopularMovies(page)) {
            is BaseResponse.Success -> {
                MovieListMapper().mapToDomain(result.data)
            }

            is BaseResponse.Error -> throw result.error
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Flow<Resource<Movie>> {
        return flow {
            when (val result = dataSourceImpl.getMovieDetail(movieId)) {
                is BaseResponse.Success -> {
                    emit(Resource.success(MovieDetailMapper().mapToDomain(result.data)))
                }

                is BaseResponse.Error -> {
                    emit(Resource.error(data = null, msg = result.error.message.orEmpty()))
                }
            }
        }.catch {
            emit(Resource.error(data = null, msg = it.localizedMessage.orEmpty()))
        }
    }

    override suspend fun getMovieReviews(movieId: Int): Flow<Resource<List<Review>>> {
        return flow {
            when (val result = dataSourceImpl.getMovieReviews(movieId)) {
                is BaseResponse.Success -> {
                    emit(Resource.success(ReviewListMapper().mapToDomain(result.data)))
                }

                is BaseResponse.Error -> {
                    emit(Resource.error(data = null, msg = result.error.message.orEmpty()))
                }
            }
        }.catch {
            emit(Resource.error(data = null, msg = it.localizedMessage.orEmpty()))
        }
    }
}
