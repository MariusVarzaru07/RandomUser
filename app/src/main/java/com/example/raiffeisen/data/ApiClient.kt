package com.example.raiffeisen.data

import com.example.raiffeisen.domain.apis.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://randomuser.me/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: UsersService by lazy {
        RetrofitClient.retrofit.create(UsersService::class.java)
    }
}