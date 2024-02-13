package com.example.randomuser.domain.repositories

import com.example.randomuser.data.models.user.Root
import retrofit2.Response

interface UserRepository {
    suspend fun getUsers(): Response<Root>
}