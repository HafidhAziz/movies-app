package com.trawlbens.hometest.domain.mapper

import com.trawlbens.hometest.data.remote.response.ReviewListResponse
import com.trawlbens.hometest.domain.model.Author
import com.trawlbens.hometest.domain.model.Review

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class ReviewListMapper : BaseMapper<ReviewListResponse?, List<Review>>() {
    override fun mapToDomain(value: ReviewListResponse?): List<Review> {
        return value?.results?.map {
            Review(
                content = it.content.orEmpty(),
                createdAt = it.created_at.orEmpty(),
                authorDetails = Author(
                    username = it.author_details?.username.orEmpty(),
                    avatarPath = it.author_details?.avatar_path.orEmpty(),
                    rating = it.author_details?.rating ?: 0
                )
            )
        } ?: emptyList()
    }
}