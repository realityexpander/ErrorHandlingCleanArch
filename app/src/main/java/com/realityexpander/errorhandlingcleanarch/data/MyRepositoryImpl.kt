package com.realityexpander.errorhandlingcleanarch.data

import com.realityexpander.errorhandlingcleanarch.domain.MyRepository
import com.realityexpander.errorhandlingcleanarch.common.Resource
import com.realityexpander.errorhandlingcleanarch.common.UiText
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyRepositoryImpl: MyRepository {

    override suspend fun submitEmail(email: String): Resource<Unit> {
        delay(500L)
        return if(Random.nextBoolean()) {
            Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()) {
                Resource.Error(
                    UiText.StringRaw("Not authenticated")
                )
            } else Resource.Error(
                UiText.StringRaw("Server error")
            )
        }
    }
}