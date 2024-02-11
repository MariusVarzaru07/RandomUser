package com.example.raiffeisen.domain.repositories

import com.example.raiffeisen.data.models.user.Root
import retrofit2.Response

interface UserRepository {
    suspend fun getUsers(): Response<Root>
}