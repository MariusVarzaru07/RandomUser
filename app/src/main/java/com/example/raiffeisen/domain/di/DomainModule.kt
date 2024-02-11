package com.example.raiffeisen.domain.di

import com.example.raiffeisen.data.repositories.UserRepositoryImpl
import com.example.raiffeisen.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}