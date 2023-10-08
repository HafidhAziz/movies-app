package com.trawlbens.hometest.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
interface BaseView : LifecycleOwner {

    fun <T> observeData(data: LiveData<T>, observer: Observer<T>) {
        data.observe(this, observer)
    }

    fun <T> observeData(data: LiveData<T>, onChanged: (T) -> Unit) {
        observeData(data, Observer { onChanged(it) })
    }
}