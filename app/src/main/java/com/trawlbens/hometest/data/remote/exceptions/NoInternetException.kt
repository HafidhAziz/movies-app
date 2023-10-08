package com.trawlbens.hometest.data.remote.exceptions

import java.io.IOException

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class NoInternetException : IOException() {

    override val message: String
        get() = "No Internet Connection"
}
