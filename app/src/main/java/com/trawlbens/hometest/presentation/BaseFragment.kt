package com.trawlbens.hometest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.trawlbens.hometest.util.Inflate

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
abstract class BaseFragment<T : ViewBinding> : Fragment(), BaseView {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: Inflate<T>

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}