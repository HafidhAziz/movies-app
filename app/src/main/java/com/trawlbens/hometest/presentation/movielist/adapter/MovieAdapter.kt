package com.trawlbens.hometest.presentation.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.trawlbens.hometest.databinding.ItemMovieBinding
import com.trawlbens.hometest.domain.model.Movie

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
class MovieAdapter(private val listener: OnClickMovieItemListener) :
    PagingDataAdapter<Movie, MovieViewHolder>(MovieModelComparator) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )
    }

    interface OnClickMovieItemListener {
        fun onClickMovieItemListener(movieId: Int)
    }

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return (oldItem.id == newItem.id)
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }
}