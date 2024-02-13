package com.example.randomuser.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.randomuser.data.models.user.Users
import com.example.randomuser.domain.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<PagingData<Users>>()

    suspend fun getUsers(): LiveData<PagingData<Users>> {
        val response = userRepository.getUsers().cachedIn(viewModelScope)
        _users.value = response.value
        return response
    }
}
