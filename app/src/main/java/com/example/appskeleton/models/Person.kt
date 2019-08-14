package com.example.appskeleton.models
import com.squareup.moshi.Json


data class Person(
        override var id: String = "1",
        @Json(name = "birth_year")
        val birthYear: String?,
        @Json(name = "created")
        val created: String?,
        @Json(name = "edited")
        val edited: String?,
        @Json(name = "eye_color")
        val eyeColor: String?,
        @Json(name = "films")
        val films: List<String>?,
        @Json(name = "gender")
        val gender: String?,
        @Json(name = "hair_color")
        val hairColor: String?,
        @Json(name = "height")
        val height: String?,
        @Json(name = "homeworld")
        val homeworld: String?,
        @Json(name = "mass")
        val mass: String?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "skin_color")
        val skinColor: String?,
        @Json(name = "species")
        val species: List<String?>?,
        @Json(name = "starships")
        val starships: List<String?>?,
        @Json(name = "url")
        val url: String?,
        @Json(name = "vehicles")
        val vehicles: List<Any?>?
): IModel