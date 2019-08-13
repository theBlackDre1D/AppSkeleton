package com.example.appskeleton.core.di

import com.example.appskeleton.repositories.interfaces.TestRepository
import com.example.appskeleton.core.use_case.GetRandomText
import com.example.appskeleton.repositories.implementations.TestRepositoryImpl
import com.example.appskeleton.view_models.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    // Repositories implementation
    single<TestRepository> { TestRepositoryImpl() }

    // View Models
    viewModel { TestViewModel(get()) }

    // Use Case
    single { GetRandomText(get()) }

//     Room database
//    single { get<NotesDatabase>().noteDAO() }
//    single { Room.databaseBuilder(androidApplication(), NotesDatabase::class.java, "notes-db").build() }
//
}