package com.example.appskeleton.core.use_case

import com.example.appskeleton.repositories.interfaces.TestRepository

class GetRandomText(val testRepository: TestRepository): UseCase<String, GetRandomText.Params>() {

    override suspend fun run(params: Params) = testRepository.getText()

    data class Params(val number: Int)
}