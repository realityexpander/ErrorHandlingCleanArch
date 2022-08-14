package com.realityexpander.errorhandlingcleanarch.domain

import com.realityexpander.errorhandlingcleanarch.common.Resource

interface MyRepository {
    suspend fun submitEmail(email: String): Resource<Unit>
}