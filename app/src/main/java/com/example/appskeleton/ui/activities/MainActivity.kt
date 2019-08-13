package com.example.appskeleton.ui.activities

import android.os.Bundle
import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.navigation.Navigation
import com.example.appskeleton.ui.fragments.TestFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigation.switchFragments(this,
            TestFragment(TestFragment.Params("nothing"))
        )
    }
}
