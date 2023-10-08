package com.trawlbens.hometest.domain.model

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
data class Review(
    val content: String = "",
    val createdAt: String = "",
    val authorDetails: Author = Author()
)