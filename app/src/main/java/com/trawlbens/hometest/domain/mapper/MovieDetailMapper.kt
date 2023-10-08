package com.trawlbens.hometest.domain.mapper

import com.trawlbens.hometest.data.model.MovieDTO
import com.trawlbens.hometest.domain.model.Movie

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class MovieDetailMapper : BaseMapper<MovieDTO?, Movie>() {
    override fun mapToDomain(value: MovieDTO?): Movie {
        return Movie(
            id = value?.id ?: 0,
            overview = value?.overview.orEmpty(),
            releaseDate = value?.release_date.orEmpty(),
            posterPath = value?.poster_path.orEmpty(),
            originalTitle = value?.original_title.orEmpty()
        )
    }
}