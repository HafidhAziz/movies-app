package com.trawlbens.hometest.domain.repositories

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.trawlbens.hometest.domain.model.Movie
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class MoviePagingSource @Inject constructor(private val repository: MovieRepository) :
    PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = repository.getPopularMovies(nextPage)
            val data = movieListResponse.results
            Log.i("xxxParamKey", params.key.toString())
            Log.i("xxxPage", movieListResponse.page.toString())
            LoadResult.Page(
                data = data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (nextPage < movieListResponse.totalPages)
                    movieListResponse.page.plus(1) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        TODO("Not yet implemented")
    }
}
