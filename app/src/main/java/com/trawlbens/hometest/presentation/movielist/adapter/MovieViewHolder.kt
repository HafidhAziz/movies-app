package com.trawlbens.hometest.presentation.movielist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trawlbens.hometest.BuildConfig
import com.trawlbens.hometest.databinding.ItemMovieBinding
import com.trawlbens.hometest.domain.model.Movie

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
class MovieViewHolder(
    private val binding: ItemMovieBinding,
    private val listener: MovieAdapter.OnClickMovieItemListener?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie?) {
        binding.tvTitleMovie.text = movie?.originalTitle
        binding.tvReleaseDate.text = movie?.releaseDate
        binding.tvOverview.text = movie?.overview
        Glide.with(binding.imageMovie.context)
            .load(BuildConfig.ORIGINAL_IMAGE_URL + "" + movie?.posterPath)
            .into(binding.imageMovie)
        itemView.setOnClickListener {
            listener?.onClickMovieItemListener(movie?.id ?: 0, movie?.originalTitle.orEmpty())
        }
    }
}