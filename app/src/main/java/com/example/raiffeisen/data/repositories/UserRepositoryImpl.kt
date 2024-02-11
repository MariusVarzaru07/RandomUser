package com.example.raiffeisen.data.repositories

import com.example.raiffeisen.data.models.user.Root
import com.example.raiffeisen.domain.apis.UsersService
import com.example.raiffeisen.domain.repositories.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val usersService: UsersService) : UserRepository {
    override suspend fun getUsers(): Response<Root> {
        return usersService.getUsers()
    }
}