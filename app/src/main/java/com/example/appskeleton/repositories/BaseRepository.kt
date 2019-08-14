package com.example.appskeleton.repositories

import com.example.appskeleton.models.IModel
import retrofit2.Call

open class BaseRepository {

    inline fun <reified M: IModel> fetchData(func: () -> Call<M>): M? {
        return func.invoke().execute().body()
    }

}