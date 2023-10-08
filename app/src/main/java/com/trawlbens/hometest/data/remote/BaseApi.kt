package com.trawlbens.hometest.data.remote

import com.trawlbens.hometest.data.remote.exceptions.NoInternetException
import com.trawlbens.hometest.data.remote.exceptions.NotFoundException
import com.trawlbens.hometest.data.remote.exceptions.UnAuthorizedException
import com.trawlbens.hometest.data.remote.exceptions.UnKnownException
import com.trawlbens.hometest.data.remote.response.BaseResponse
import retrofit2.HttpException
import retrofit2.Response
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
abstract class BaseApi {

    protected suspend fun <T : Any> createCall(call: suspend () -> Response<T>): BaseResponse<T> {

        val response: Response<T>
        try {
            response = call.invoke()
        } catch (t: Throwable) {
            t.printStackTrace()
            return BaseResponse.Error(mapToNetworkError(t))
        }

        if (response.isSuccessful) {
            if (response.body() != null) {
                return BaseResponse.Success(response.body()!!)
            }
        } else {
            val errorBody = response.errorBody()
            return if (errorBody != null) {
                BaseResponse.Error(mapApiException(response.code()))
            } else BaseResponse.Error(mapApiException(0))
        }
        return BaseResponse.Error(HttpException(response))
    }

    private fun mapApiException(code: Int): Exception {
        return when (code) {
            HttpURLConnection.HTTP_NOT_FOUND -> NotFoundException()
            HttpURLConnection.HTTP_UNAUTHORIZED -> UnAuthorizedException()
            else -> UnKnownException()
        }
    }

    private fun mapToNetworkError(t: Throwable): Exception {
        return when (t) {
            is SocketTimeoutException
            -> SocketTimeoutException("Connection Timed Out")

            is UnknownHostException
            -> NoInternetException()

            else
            -> UnKnownException()

        }
    }
}
