package com.trawlbens.hometest.data.remote.response

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
sealed class BaseResponse<out T: Any> {
    data class Success<out T: Any>(val data: T) : BaseResponse<T>()
    data class Error(val error: Exception) : BaseResponse<Nothing>()
}
