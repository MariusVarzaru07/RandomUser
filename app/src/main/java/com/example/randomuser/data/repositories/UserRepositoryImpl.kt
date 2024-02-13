package com.example.randomuser.data.repositories

import com.example.randomuser.data.models.user.Root
import com.example.randomuser.domain.apis.UsersService
import com.example.randomuser.domain.repositories.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val usersService: UsersService) : UserRepository {
    override suspend fun getUsers(): Response<Root> {
        return usersService.getUsers()
    }
}