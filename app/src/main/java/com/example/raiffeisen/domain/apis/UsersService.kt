package com.example.raiffeisen.domain.apis

import com.example.raiffeisen.data.models.Users
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {
    @GET("api")
    suspend fun getUsers(): Response<Users>
}
