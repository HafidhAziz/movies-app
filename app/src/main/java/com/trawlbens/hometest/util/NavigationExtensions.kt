package com.trawlbens.hometest.util

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

/**
 * Created by M.Hafidh Abdul Aziz on 09/10/23.
 */
fun Fragment.navigateTo(directions: NavDirections) {
    try {
        findNavController().navigate(directions)
    } catch (e: IllegalArgumentException) {
        // User probably tapping 2 navigation at once!
        Log.e(this::class.java.simpleName, "Can't open 2 links at once!")
    }
}

fun Fragment.navigateBack(){
    try {
        findNavController().popBackStack()
    } catch (e: IllegalArgumentException) {
        // User probably tapping 2 navigation at once!
        Log.e(this::class.java.simpleName, "Can't open 2 links at once!")
    }
}