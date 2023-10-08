package com.trawlbens.hometest.presentation.favorite.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trawlbens.hometest.BuildConfig
import com.trawlbens.hometest.data.local.FavoriteMovie
import com.trawlbens.hometest.databinding.ItemMovieBinding

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class FavoriteMovieViewHolder(
    private val binding: ItemMovieBinding,
    private val listener: FavoriteAdapter.OnClickMovieItemListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: FavoriteMovie) {
        binding.tvTitleMovie.text = movie.title
        binding.tvReleaseDate.text = movie.releaseDate
        binding.tvOverview.text = movie.overview
        Glide.with(binding.imageMovie.context)
            .load(BuildConfig.ORIGINAL_IMAGE_URL + "" + movie.imageUrl)
            .into(binding.imageMovie)
        itemView.setOnClickListener {
            listener?.onClickMovieItemListener(movie.idMovie, movie.title)
        }
    }
}