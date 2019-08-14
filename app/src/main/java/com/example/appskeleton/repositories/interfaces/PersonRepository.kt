package com.example.appskeleton.repositories.interfaces

import com.example.appskeleton.models.Person

interface PersonRepository {
    fun getPerson(id: String): Person?
}