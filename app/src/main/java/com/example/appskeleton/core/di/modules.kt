package com.example.appskeleton.core.di

import androidx.room.Room
import com.example.appskeleton.core.net.StarWarsAPI
import com.example.appskeleton.database.StarWarsDatabase
import com.example.appskeleton.repositories.implementations.PersonRepositoryImpl
import com.example.appskeleton.repositories.interfaces.TestRepository
import com.example.appskeleton.repositories.implementations.TestRepositoryImpl
import com.example.appskeleton.repositories.interfaces.PersonRepository
import com.example.appskeleton.use_case.GetPerson
import com.example.appskeleton.use_case.GetSavedPeople
import com.example.appskeleton.use_case.SavePerson
import com.example.appskeleton.view_models.PersonViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    // Repositories implementation
    single<TestRepository> { TestRepositoryImpl() }
    single<PersonRepository> { PersonRepositoryImpl( get(), get() ) }

    // View Models
    viewModel { PersonViewModel( get(), get(), get() ) }

    // Use Case
    single { GetPerson( get() ) }
    single { SavePerson( get() ) }
    single { GetSavedPeople( get() ) }

    // Retrofit
    single { StarWarsAPI.create() }

//     Room database
    single { get<StarWarsDatabase>().personDao() }
    single { Room.databaseBuilder(androidApplication(), StarWarsDatabase::class.java, "star-wars-db").build() }

}