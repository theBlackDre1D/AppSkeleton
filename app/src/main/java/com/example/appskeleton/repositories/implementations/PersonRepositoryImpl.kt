package com.example.appskeleton.repositories.implementations

import com.example.appskeleton.core.net.StarWarsAPI
import com.example.appskeleton.models.Person
import com.example.appskeleton.repositories.BaseRepository
import com.example.appskeleton.repositories.interfaces.PersonRepository

class PersonRepositoryImpl(private val service: StarWarsAPI): BaseRepository(), PersonRepository {

    override fun getPerson(id: String): Person? {
        return fetchData { service.getPersonById(id) }
    }
}