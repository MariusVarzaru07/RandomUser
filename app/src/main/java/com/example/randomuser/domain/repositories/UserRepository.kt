package com.example.randomuser.domain.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.randomuser.data.models.user.Users

interface UserRepository {
    suspend fun getUsers(): LiveData<PagingData<Users>>
}