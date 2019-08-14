package com.example.appskeleton.view_models

import androidx.lifecycle.MutableLiveData
import com.example.appskeleton.core.base.BaseViewModel
import com.example.appskeleton.models.Person
import com.example.appskeleton.use_case.GetPerson

class GetPersonViewModel(getPerson: GetPerson): BaseViewModel<Person?, GetPerson.Params, GetPerson>(getPerson) {

    override val liveData = MutableLiveData<Person?>()
}