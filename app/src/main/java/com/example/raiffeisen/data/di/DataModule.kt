package com.example.raiffeisen.data.di

import com.example.raiffeisen.domain.apis.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://randomuser.me/"

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideUserService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }
}