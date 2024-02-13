package com.example.randomuser.domain.apis

import com.example.randomuser.data.models.user.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET("api")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String
    ): Response<Root>
}
