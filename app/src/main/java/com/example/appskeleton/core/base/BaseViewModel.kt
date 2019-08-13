package com.example.appskeleton.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appskeleton.core.use_case.UseCase

abstract class BaseViewModel<DataType, Params, UC: UseCase<DataType, Params>>
    (private val useCase: UC): ViewModel() {

    abstract val liveData: MutableLiveData<DataType>

    open fun loadData(params: Params) = useCase(params) { handleRespond(it) }

    private fun handleRespond(data: DataType) { liveData.value = data }

    override fun onCleared() {
        super.onCleared()
        useCase.job.cancel()
    }
}