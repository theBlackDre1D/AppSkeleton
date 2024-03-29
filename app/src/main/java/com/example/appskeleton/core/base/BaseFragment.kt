package com.example.appskeleton.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appskeleton.core.extension.visibleOrGone
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseFragment: Fragment() {

    abstract val layoutResource: Int
    private val activity: BaseActivity
        get() = getActivity() as BaseActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelsObservers()
        setupUI()
    }

    open fun setupUI() {
        setupListeners()
    }

    open fun setupViewModelsObservers() {}
    open fun setupListeners() {}

    fun showOrHideLoading(visible: Boolean = true) { activity.loadingContainer.visibleOrGone(visible) }

}