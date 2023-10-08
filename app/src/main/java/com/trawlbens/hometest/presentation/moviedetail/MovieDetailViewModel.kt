package com.trawlbens.hometest.presentation.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trawlbens.hometest.domain.model.Movie
import com.trawlbens.hometest.domain.model.Review
import com.trawlbens.hometest.domain.repositories.Repository
import com.trawlbens.hometest.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _movieDetailData = MutableLiveData<Movie>()
    val movieDetailData: LiveData<Movie>
        get() = _movieDetailData

    private val _reviewData = MutableLiveData<List<Review>>()
    val reviewData: LiveData<List<Review>>
        get() = _reviewData

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovieDetail(movieId).collect { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            _movieDetailData.postValue(it)
                        }
                    }

                    else -> {
                        //handle error here
                    }
                }
            }
        }
    }

    fun getMovieReviews(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovieReviews(movieId).collect { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            _reviewData.postValue(it)
                        }
                    }

                    else -> {
                        //handle error here
                    }
                }
            }
        }
    }
}