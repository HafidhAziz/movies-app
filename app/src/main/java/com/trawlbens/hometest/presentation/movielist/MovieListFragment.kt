package com.trawlbens.hometest.presentation.movielist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.trawlbens.hometest.R
import com.trawlbens.hometest.databinding.FragmentMovieListBinding
import com.trawlbens.hometest.presentation.BaseFragment
import com.trawlbens.hometest.presentation.movielist.adapter.MovieAdapter
import com.trawlbens.hometest.presentation.movielist.adapter.MovieLoadStateAdapter
import com.trawlbens.hometest.util.Inflate
import com.trawlbens.hometest.util.navigateTo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>() {

    private val viewModel: MovieListViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter
    override val bindingInflater: Inflate<FragmentMovieListBinding> =
        FragmentMovieListBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupUI()
        fetchMovies()
    }

    private fun setupToolbar() = with(binding) {
        toolbarHome.apply {
            tvTitle.text = getString(R.string.app_name)
            btnBack.visibility = View.GONE
            btnFav.visibility = View.VISIBLE
            btnFav.setOnClickListener {
                gotoFavorite()
            }
        }
    }

    private fun setupUI() {
        movieAdapter = MovieAdapter(object : MovieAdapter.OnClickMovieItemListener {
            override fun onClickMovieItemListener(movieId: Int, movieName: String) {
                gotoDetail(movieId, movieName)
            }
        })
        binding.rvHomeMovieList.adapter = movieAdapter.withLoadStateFooter(
            footer = MovieLoadStateAdapter { movieAdapter.retry() }
        )

        binding.btnRetry.setOnClickListener {
            movieAdapter.retry()
        }

        movieAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                binding.btnRetry.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> {
                        binding.btnRetry.visibility = View.VISIBLE
                        loadState.refresh as LoadState.Error
                    }

                    else -> null
                }
                errorState?.let {
                    Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun fetchMovies() {
        lifecycleScope.launch {
            viewModel.moviesPagingData.collectLatest {
                movieAdapter.submitData(it)
            }
        }
    }

    private fun gotoFavorite() {
        //todo fav
    }

    private fun gotoDetail(movieId: Int, movieName: String) {
        navigateTo(MovieListFragmentDirections.openMovieDetail(movieId, movieName))
    }
}