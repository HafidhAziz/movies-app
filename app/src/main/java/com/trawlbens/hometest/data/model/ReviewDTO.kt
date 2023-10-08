package com.trawlbens.hometest.data.model

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
data class ReviewDTO(
    val content: String? = null,
    val created_at: String? = null,
    val author_details: AuthorDTO? = null
)