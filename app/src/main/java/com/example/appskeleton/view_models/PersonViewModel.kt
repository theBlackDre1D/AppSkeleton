package com.example.appskeleton.view_models

import androidx.lifecycle.MutableLiveData
import com.example.appskeleton.core.base.BaseViewModel
import com.example.appskeleton.models.Person
import com.example.appskeleton.use_case.GetPerson
import com.example.appskeleton.use_case.GetSavedPeople
import com.example.appskeleton.use_case.SavePerson

class PersonViewModel(getPerson: GetPerson,
                      val savePerson: SavePerson,
                      val getSavedPerson: GetSavedPeople): BaseViewModel<Person?, GetPerson.Params, GetPerson>(getPerson) {

    override val liveData = MutableLiveData<Person?>()
    val savedPeople = MutableLiveData<List<Person>>()

    override fun handleRespond(data: Person?) {
        super.handleRespond(data)

        data?.let { savePerson(data) {} }
    }

    fun loadPeople() {
        getSavedPerson(Any()) {
            val people = ArrayList<Person>()
            it.forEach { people.add(Person(name = it.name)) }
            savedPeople.value = people
        }
    }
}