package com.trawlbens.hometest.domain.model

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
data class Movie(
    val id: Int,
    val originalTitle: String = "",
    val posterPath: String = "",
    val overview: String = "",
    val releaseDate: String = "",
)