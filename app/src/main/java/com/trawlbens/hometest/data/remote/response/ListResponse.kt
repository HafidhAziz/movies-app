package com.trawlbens.hometest.data.remote.response

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
open class ListResponse<Item> {
    val total_pages: Int? = null
    val total_results: Int? = null
    val results: List<Item>? = null
    val page: Int = 0
}
