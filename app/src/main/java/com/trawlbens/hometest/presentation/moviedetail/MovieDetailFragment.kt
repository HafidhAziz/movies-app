package com.trawlbens.hometest.presentation.moviedetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.trawlbens.hometest.BuildConfig
import com.trawlbens.hometest.R
import com.trawlbens.hometest.data.local.FavoriteMovieDataSource
import com.trawlbens.hometest.databinding.FragmentMovieDetailBinding
import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.presentation.BaseFragment
import com.trawlbens.hometest.presentation.moviedetail.adapter.ReviewAdapter
import com.trawlbens.hometest.util.Inflate
import com.trawlbens.hometest.util.navigateBack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>() {

    override val bindingInflater: Inflate<FragmentMovieDetailBinding> =
        FragmentMovieDetailBinding::inflate

    @Inject
    lateinit var favoriteMovieDataSource: FavoriteMovieDataSource
    private val viewModel: MovieDetailViewModel by viewModels()
    private lateinit var reviewAdapter: ReviewAdapter
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        setupUI()
        setupObserver()
        viewModel.getMovieDetail(args.movieId)
        viewModel.getMovieReviews(args.movieId)
    }

    private fun setupToolbar() = with(binding) {
        toolbarMovieDetail.apply {
            tvTitle.text = args.movieTitle
            btnBack.visibility = View.VISIBLE
            btnBack.setOnClickListener {
                navigateBack()
            }
            btnFav.visibility = View.GONE
        }
    }

    private fun setupUI() = with(binding) {
        reviewAdapter = ReviewAdapter(arrayListOf())
        rvReview.adapter = reviewAdapter

        binding.imageFavAction.setOnClickListener {
            favoriteMovieDataSource.isItemExists(args.movieId) {
                if (it) {
                    onClickUnFavorite()
                } else {
                    onClickFavorite()
                }
            }
        }
    }

    private fun setupObserver() {
        observeData(viewModel.movieDetailData) { data ->
            setDataToView(data)
        }
        observeData(viewModel.reviewData) { reviews ->
            reviewAdapter.addData(reviews)
        }
    }

    private fun setDataToView(data: Movie) {
        binding.apply {
            tvTitleMovieDetail.text = data.originalTitle
            tvReleaseDate.text = data.releaseDate
            tvOverview.text = data.overview
            Glide.with(imageMovieDetail.context)
                .load(BuildConfig.ORIGINAL_IMAGE_URL + "" + data.posterPath)
                .into(imageMovieDetail)
        }

        favoriteMovieDataSource.isItemExists(data.id) {
            if (it) {
                binding.imageFavAction.setImageResource(R.drawable.ic_fav_selected)
            } else {
                binding.imageFavAction.setImageResource(R.drawable.ic_fav)
            }
        }
    }

    private fun onClickFavorite() {
        favoriteMovieDataSource.addMovie(
            args.movieId,
            args.movieTitle,
            viewModel.movieDetailData.value?.posterPath.orEmpty(),
            viewModel.movieDetailData.value?.releaseDate.orEmpty(),
            viewModel.movieDetailData.value?.overview.orEmpty()
        )
        binding.imageFavAction.setImageResource(R.drawable.ic_fav_selected)
    }

    private fun onClickUnFavorite() {
        favoriteMovieDataSource.deleteItemById(args.movieId)
        binding.imageFavAction.setImageResource(R.drawable.ic_fav)
    }
}