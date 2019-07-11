package com.example.appskeleton

import android.os.Bundle
import com.example.appskeleton.core.base.BaseActivity
import com.example.appskeleton.core.navigation.Navigation
import com.example.appskeleton.features.test.TestFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigation.switchFragments(this,
            TestFragment(TestFragment.Params("nothing")))
    }
}
