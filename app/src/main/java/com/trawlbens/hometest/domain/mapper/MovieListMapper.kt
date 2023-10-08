package com.trawlbens.hometest.domain.mapper

import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.domain.model.MovieList
import com.trawlbens.hometest.data.remote.response.MovieListResponse

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
class MovieListMapper : BaseMapper<MovieListResponse?, MovieList>() {
    override fun mapToDomain(value: MovieListResponse?): MovieList {
        return MovieList(
            totalPages = value?.total_pages ?: 0,
            totalResults = value?.total_results ?: 0,
            results = value?.results?.map {
                Movie(
                    id = it.id ?: 0,
                    overview = it.overview.orEmpty(),
                    releaseDate = it.release_date.orEmpty(),
                    posterPath = it.poster_path.orEmpty(),
                    originalTitle = it.original_title.orEmpty()
                )
            } ?: emptyList(),
            page = value?.page ?: 0
        )
    }
}