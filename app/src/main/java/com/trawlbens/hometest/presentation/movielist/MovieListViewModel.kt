package com.trawlbens.hometest.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.domain.repositories.MoviePagingSource
import com.trawlbens.hometest.domain.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
@HiltViewModel
class MovieListViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    val moviesPagingData: Flow<PagingData<Movie>> = getMovieListStream()
        .map { pagingData -> pagingData.map { it } }

    private fun getMovieListStream(): Flow<PagingData<Movie>> {
        // fix issue #1 in Slide by adding prefetchDistance param for loading in chosen position
        return Pager(PagingConfig(20, prefetchDistance = 10)) {
            MoviePagingSource(repository)
        }.flow
    }
}