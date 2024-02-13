package com.example.randomuser.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.randomuser.data.models.user.Users
import com.example.randomuser.data.pagingsources.UsersPagingSource
import com.example.randomuser.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val usersPagingSource: UsersPagingSource) :
    UserRepository {
    override suspend fun getUsers(): LiveData<PagingData<Users>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                usersPagingSource
            }
        ).liveData
    }
}