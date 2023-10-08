package com.trawlbens.hometest.presentation.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trawlbens.hometest.databinding.ViewLoadStateBinding

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
class MovieLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MovieLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        val progress = holder.loadStateViewBinding.loadStateProgressBar
        val btnRetry = holder.loadStateViewBinding.btnLoadStateRetry
        val tvLoadStateError = holder.loadStateViewBinding.tvLoadStateError

        btnRetry.isVisible = loadState !is LoadState.Loading
        tvLoadStateError.isVisible = loadState !is LoadState.Loading
        progress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error) {
            tvLoadStateError.text = loadState.error.localizedMessage
        }

        btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ViewLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class LoadStateViewHolder(val loadStateViewBinding: ViewLoadStateBinding) :
        RecyclerView.ViewHolder(loadStateViewBinding.root)
}
