package com.example.appskeleton.repositories.interfaces

import com.example.appskeleton.database.PersonEntity
import com.example.appskeleton.models.Person

interface PersonRepository {
    fun getPerson(id: String): Person?
    fun savePerson(person: Person): Long
    fun getSavedPeople(): List<PersonEntity>
}