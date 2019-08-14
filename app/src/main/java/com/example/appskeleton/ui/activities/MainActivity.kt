package com.example.appskeleton.ui.activities

import android.os.Bundle
import android.os.Handler
import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.navigation.Navigation
import com.example.appskeleton.flow_controllers.LoginFlowController
import com.example.appskeleton.managers.UserManager
import com.example.appskeleton.ui.fragments.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({ nextStep() }, 1200) // not best practice force user to wait
    }

    private fun nextStep() {
        if (!UserManager.isLogin) { LoginFlowController(this).start() }
        else {
            Navigation.switchFragments(this, MainFragment(), true)
        }
    }
}
