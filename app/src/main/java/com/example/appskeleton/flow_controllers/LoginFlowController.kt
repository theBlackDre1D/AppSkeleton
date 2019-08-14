package com.example.appskeleton.flow_controllers

import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.navigation.Navigation
import com.example.appskeleton.ui.fragments.MainFragment
import com.example.appskeleton.ui.fragments.login.LoginFragment

class LoginFlowController(val activity: BaseActivity) {

    fun start() {
        Navigation.switchFragments(activity,
            LoginFragment(LoginFragment.Param(::finish)))
    }

    private fun finish(email: String, userName: String) {
        Navigation.switchFragments(activity, MainFragment(), true)
    }
}