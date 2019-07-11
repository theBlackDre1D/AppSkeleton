package com.example.appskeleton.core.navigation

import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.base.BaseFragment
import com.example.appskeleton.core.extension.simpleReplace

object Navigation {

    fun <A: BaseActivity, F: BaseFragment> switchFragments(activity: A, newFragment: F) {
        val transition = activity.supportFragmentManager.beginTransaction()
        transition.simpleReplace(R.id.container, newFragment)
    }

    fun pop(activity: BaseActivity) {
        activity.supportFragmentManager.popBackStack()
    }
}