package com.trawlbens.hometest.presentation.favorite.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trawlbens.hometest.data.local.FavoriteMovie
import com.trawlbens.hometest.databinding.ItemMovieBinding

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
class FavoriteAdapter(
    private val movies: ArrayList<FavoriteMovie>,
    private val listener: OnClickMovieItemListener
) : RecyclerView.Adapter<FavoriteMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteMovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener = listener
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: List<FavoriteMovie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    interface OnClickMovieItemListener {
        fun onClickMovieItemListener(movieId: Int, movieName: String)
    }
}