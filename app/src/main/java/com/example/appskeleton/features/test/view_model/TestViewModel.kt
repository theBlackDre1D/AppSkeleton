package com.example.appskeleton.features.test.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appskeleton.features.test.GetRandomText

class TestViewModel(private val getText: GetRandomText): ViewModel() {

    val liveData = MutableLiveData<String>()

    fun loadData(params: GetRandomText.Params) = getText(params) { handleRespond(it) }

    private fun handleRespond(data: String) { liveData.value = data }

    override fun onCleared() {
        super.onCleared()

        getText.getJob().cancel()
    }
}