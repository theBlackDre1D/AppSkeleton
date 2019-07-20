package com.example.appskeleton.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract val layoutResource: Int
    protected val activity: BaseActivity
        get() = getActivity() as BaseActivity

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(layoutResource, container, false)
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        setupUI()
//    }

    open fun setupUI() {
        setupViewModelsObservers()
    }

    open fun setupViewModelsObservers() {}

}