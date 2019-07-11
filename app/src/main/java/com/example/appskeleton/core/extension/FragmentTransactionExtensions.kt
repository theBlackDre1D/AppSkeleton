package com.example.appskeleton.core.extension

import androidx.fragment.app.FragmentTransaction
import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseFragment

fun FragmentTransaction.simpleReplace(frameLayoutID: Int, fragment: BaseFragment) {
    setCustomAnimations(R.anim.abc_slide_in_top, R.anim.abc_popup_exit)
    replace(frameLayoutID, fragment, fragment::class.simpleName)
    addToBackStack(fragment::class.simpleName)
    commit()
}