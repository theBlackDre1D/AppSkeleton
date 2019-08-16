package com.example.appskeleton.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_entity")
    fun getPeople(): List<PersonEntity>

    @Insert
    fun savePerson(person: PersonEntity): Long
}