package com.example.appskeleton.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 1)
abstract class StarWarsDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        private var INSTANCE: StarWarsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            StarWarsDatabase::class.java,
            "star-wars-db").build()
    }

}