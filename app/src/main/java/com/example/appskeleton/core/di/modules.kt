package com.example.appskeleton.core.di

import com.example.appskeleton.features.TestRepository
import com.example.appskeleton.features.test.GetRandomText
import com.example.appskeleton.features.test.TestRepositoryImpl
import com.example.appskeleton.features.test.view_model.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module {

    // Repositories implementation
    single<TestRepository> { TestRepositoryImpl() }

    // View Models
    viewModel { TestViewModel( get() ) }

    // Use Case
    single { GetRandomText( get() ) }

//     Room database
//    single { get<NotesDatabase>().noteDAO() }
//    single { Room.databaseBuilder(androidApplication(), NotesDatabase::class.java, "notes-db").build() }
//
//    // Repositories implementation
//    single<TestRepository> { TextRepositoryImp( get() ) }
//
//    // Use Cases
//    single { GetRandomText( get() ) }
//    single { GetNotesFromDatabase( get() ) }
//    single { AddNewNote( get() ) }
//
//    // View Models
//    viewModel { GetTextViewModel( get(), get() ) }
//    viewModel { AddNoteViewModel( get() ) }
}