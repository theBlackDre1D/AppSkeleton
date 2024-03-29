package com.example.appskeleton.use_case

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> {

    val job = SupervisorJob()

    abstract suspend fun run(params: Params): Type

    operator fun invoke(params: Params, onResult: (Type) -> Unit = {}) {

        val result = CoroutineScope(Dispatchers.IO + job).async {
            run(params)
        }
        CoroutineScope(Dispatchers.Main).launch { onResult(result.await()) }
    }
}