package com.example.appskeleton.models
import com.squareup.moshi.Json


data class Person(

        // Put only necessary attributes

        override var id: String = "1",
        @Json(name = "name")
        val name: String
): IModel