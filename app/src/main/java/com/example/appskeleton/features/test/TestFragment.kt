package com.example.appskeleton.features.test

import androidx.lifecycle.Observer
import com.example.appskeleton.R
import com.example.appskeleton.core.base.BaseInputFragment
import com.example.appskeleton.core.navigation.Navigation
import com.example.appskeleton.features.SecondFragment
import com.example.appskeleton.features.test.view_model.TestViewModel
import kotlinx.android.synthetic.main.fragment_test.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TestFragment(override var params: Params?): BaseInputFragment<TestFragment.Params>(params) {

    override val layoutResource: Int
        get() = R.layout.fragment_test

    data class Params(val nothing: String) : BaseParams()

    private val textViewModel: TestViewModel by viewModel()

    override fun setupViewModelsObservers() {
        textViewModel.liveData.observe(this, Observer { tvMainText.text = it })
    }

    override fun setupUI() {
        super.setupUI()
        bGetText.setOnClickListener { textViewModel.loadData(GetRandomText.Params(0)) }
        bMiddleButton.setOnClickListener {
            Navigation.switchFragments(activity, SecondFragment())
        }
    }

}