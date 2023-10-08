package com.trawlbens.hometest.presentation.moviedetail.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trawlbens.hometest.databinding.ItemUserReviewBinding
import com.trawlbens.hometest.domain.model.Review

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class ReviewAdapter(
    private val review: ArrayList<Review>
) : RecyclerView.Adapter<ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ReviewViewHolder(
            ItemUserReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )

    override fun getItemCount(): Int = review.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(review[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: List<Review>) {
        review.clear()
        review.addAll(list)
        notifyDataSetChanged()
    }
}