package com.example.appskeleton.core.di

import com.example.appskeleton.core.net.StarWarsAPI
import com.example.appskeleton.repositories.implementations.PersonRepositoryImpl
import com.example.appskeleton.repositories.interfaces.TestRepository
import com.example.appskeleton.repositories.implementations.TestRepositoryImpl
import com.example.appskeleton.repositories.interfaces.PersonRepository
import com.example.appskeleton.use_case.GetPerson
import com.example.appskeleton.view_models.GetPersonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    // Repositories implementation
    single<TestRepository> { TestRepositoryImpl() }
    single<PersonRepository> { PersonRepositoryImpl( get() ) }

    // View Models
    viewModel { GetPersonViewModel( get() ) }

    // Use Case
    single { GetPerson( get() ) }

    // Retrofit
    single { StarWarsAPI.create() }

//     Room database
//    single { get<NotesDatabase>().noteDAO() }
//    single { Room.databaseBuilder(androidApplication(), NotesDatabase::class.java, "notes-db").build() }
//
}