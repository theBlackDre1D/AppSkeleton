package com.example.appskeleton.view_models

import androidx.lifecycle.MutableLiveData
import com.example.appskeleton.core.base.BaseViewModel
import com.example.appskeleton.core.use_case.GetRandomText

class TestViewModel(private val getText: GetRandomText): BaseViewModel<String, GetRandomText.Params, GetRandomText>(getText) {

    override val liveData = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        getText.job.cancel()
    }
}