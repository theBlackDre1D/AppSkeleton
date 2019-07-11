package com.example.appskeleton.features.test

import com.example.appskeleton.core.use_case.UseCase
import com.example.appskeleton.features.TestRepository

class GetRandomText(val testRepository: TestRepository): UseCase<String, GetRandomText.Params>() {

    override suspend fun run(params: Params) = testRepository.getText()

    data class Params(val number: Int)
}