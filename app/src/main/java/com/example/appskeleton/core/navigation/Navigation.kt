package com.example.appskeleton.core.navigation

import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.base.BaseFragment
import com.example.appskeleton.core.extension.simpleReplace
import kotlin.reflect.KClass

object Navigation {

    fun <A: BaseActivity, F: BaseFragment> switchFragments(activity: A, newFragment: F) {
        val transition = activity.supportFragmentManager.beginTransaction()
        transition.simpleReplace(R.id.container, newFragment)
    }

    fun pop(activity: BaseActivity) {
        activity.supportFragmentManager.popBackStack()
    }

    fun <T: BaseFragment> popToFragment(fragClass: KClass<T>, activity: BaseActivity) {
        activity.supportFragmentManager.popBackStackImmediate(fragClass.simpleName, 0)
    }
}