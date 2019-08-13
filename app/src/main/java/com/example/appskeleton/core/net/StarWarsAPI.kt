package com.example.appskeleton.core.net

import com.example.appskeleton.BuildConfig
import com.example.appskeleton.models.Person
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsAPI {

    @GET(" people/{id}/")
    fun getPersonById(@Path("id") id: String): Deferred<Response<Person>>

    companion object {
        fun create(): StarWarsAPI {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.STAR_WARS_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(StarWarsAPI::class.java)
        }
    }
}