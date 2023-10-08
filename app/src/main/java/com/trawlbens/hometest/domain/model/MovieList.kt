package com.trawlbens.hometest.domain.model

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
data class MovieList(
    val totalPages: Int = 0,
    val totalResults: Int = 0,
    val results: List<Movie> = emptyList(),
    val page: Int = 0
)