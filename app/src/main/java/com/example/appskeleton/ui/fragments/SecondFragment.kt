package com.example.appskeleton.ui.fragments

import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseFragment
import com.example.appskeleton.core.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_test.*

class SecondFragment: BaseFragment() {

    override val layoutResource: Int
        get() = R.layout.fragment_test


    override fun setupUI() {
        super.setupUI()

        bMiddleButton.setOnClickListener {
            Navigation.popToFragment(TestFragment::class, activity)
        }
    }
}