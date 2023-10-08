package com.trawlbens.hometest.data.remote.exceptions

import java.lang.Exception

/**
 * Created by M.Hafidh Abdul Aziz on 07/10/23.
 */
class UnKnownException : Exception() {

    override val message: String
        get() = "Some Unknown Error Occurred"
}
