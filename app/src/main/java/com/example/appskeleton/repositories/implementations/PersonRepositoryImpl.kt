package com.example.appskeleton.repositories.implementations

import com.example.appskeleton.core.net.StarWarsAPI
import com.example.appskeleton.database.PersonDao
import com.example.appskeleton.database.PersonEntity
import com.example.appskeleton.models.Person
import com.example.appskeleton.repositories.BaseRepository
import com.example.appskeleton.repositories.interfaces.PersonRepository

class PersonRepositoryImpl(
    private val service: StarWarsAPI,
    private val database: PersonDao
    ): BaseRepository(), PersonRepository {

    override fun getPerson(id: String): Person? {
        return fetchData { service.getPersonById(id) }
    }

    override fun savePerson(person: Person): Long {
        return database.savePerson(PersonEntity(0L, person.name))
    }

    override fun getSavedPeople(): List<PersonEntity> {
        return database.getPeople()
    }
}