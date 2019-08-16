package com.example.appskeleton.use_case

import com.example.appskeleton.database.PersonEntity
import com.example.appskeleton.models.Person
import com.example.appskeleton.repositories.interfaces.PersonRepository

class GetPerson(val repository: PersonRepository): UseCase<Person?, GetPerson.Params>() {

    override suspend fun run(params: Params) = repository.getPerson(params.id)

    data class Params(val id: String)
}

class SavePerson(val repository: PersonRepository): UseCase<Long, Person>() {

    override suspend fun run(params: Person) = repository.savePerson(params)

}

class GetSavedPeople(val repository: PersonRepository): UseCase<List<PersonEntity>, Any>() {
    override suspend fun run(params: Any) = repository.getSavedPeople()
}