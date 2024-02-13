package com.example.randomuser.domain.apis

import com.example.randomuser.data.models.user.Root
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {
    @GET("api")
    suspend fun getUsers(): Response<Root>
}
