package com.example.randomuser.presentation.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.data.models.user.Users
import com.example.randomuser.domain.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>>
        get() = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        try {
            viewModelScope.launch {
                val result = userRepository.getUsers()

                withContext(Dispatchers.Main) {
                    if (result.isSuccessful)
                        result.body()?.let { body ->
                            _users.postValue(body.results)
                        }
                }
            }

        } catch (exception: Exception) {

        }
    }
}
