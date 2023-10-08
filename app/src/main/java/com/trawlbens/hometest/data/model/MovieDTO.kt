package com.trawlbens.hometest.data.model

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
data class MovieDTO(
    val id: Int? = null,
    val original_title: String? = null,
    val backdrop_path: String? = null,
    val poster_path: String? = null,
    val overview: String? = null,
    val adult: Boolean? = null,
    val release_date: String? = null,
    val original_language: String? = null,
    val popularity: Double? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)