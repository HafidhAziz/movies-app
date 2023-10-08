package com.trawlbens.hometest.presentation.moviedetail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trawlbens.hometest.BuildConfig
import com.trawlbens.hometest.databinding.ItemUserReviewBinding
import com.trawlbens.hometest.domain.model.Review

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class ReviewViewHolder(
    private val binding: ItemUserReviewBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(review: Review) {
        review.authorDetails.rating.let {
            binding.tvRating.text = it.toString()
        }
        binding.tvAuthor.text = review.authorDetails.username
        binding.tvContent.text = review.content
        Glide.with(binding.imageAuthor.context)
            .load(BuildConfig.ORIGINAL_IMAGE_URL + "" + review.authorDetails.avatarPath)
            .into(binding.imageAuthor)
    }
}