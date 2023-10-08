package com.trawlbens.hometest.presentation.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.trawlbens.hometest.R
import com.trawlbens.hometest.data.local.FavoriteMovieDataSource
import com.trawlbens.hometest.databinding.FragmentFavoriteBinding
import com.trawlbens.hometest.presentation.BaseFragment
import com.trawlbens.hometest.presentation.favorite.adapter.FavoriteAdapter
import com.trawlbens.hometest.presentation.movielist.MovieListFragmentDirections
import com.trawlbens.hometest.util.Inflate
import com.trawlbens.hometest.util.navigateBack
import com.trawlbens.hometest.util.navigateTo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    @Inject
    lateinit var favoriteMovieDataSource: FavoriteMovieDataSource
    override val bindingInflater: Inflate<FragmentFavoriteBinding> =
        FragmentFavoriteBinding::inflate
    private val viewModel: FavoriteViewModel by viewModels()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupUI()
        getFavoriteMovies()
    }

    private fun setupToolbar() {
        binding.toolbarFavorite.apply {
            tvTitle.text = getString(R.string.favorite_movie_label)
            btnBack.visibility = View.VISIBLE
            btnBack.setOnClickListener {
                navigateBack()
            }
            btnFav.visibility = View.GONE
        }
    }

    private fun setupUI() {
        favoriteAdapter =
            FavoriteAdapter(arrayListOf(), object : FavoriteAdapter.OnClickMovieItemListener {
                override fun onClickMovieItemListener(movieId: Int, movieName: String) {
                    navigateTo(MovieListFragmentDirections.openMovieDetail(movieId, movieName))
                }
            })
        binding.rvFavoriteMovieList.adapter = favoriteAdapter
    }

    private fun getFavoriteMovies() {
        favoriteMovieDataSource.getAllFavoriteMovies {
            if (it.isNotEmpty()) {
                favoriteAdapter.addData(it)
            }
            binding.rvFavoriteMovieList.visibility = if (it.isEmpty()) View.GONE else View.VISIBLE
            binding.tvFavEmpty.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}