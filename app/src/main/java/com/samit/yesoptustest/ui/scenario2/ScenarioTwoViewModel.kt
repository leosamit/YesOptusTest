package com.samit.yesoptustest.ui.scenario2

import androidx.lifecycle.ViewModel
import com.samit.yesoptustest.data.repo.UserRepository
import javax.inject.Inject

class ScenarioTwoViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {

    init {
        repository.getUsers()
    }

    val userInfoList = repository.usersList

    fun refreshUserInfo() {
        repository.getUsers()
    }

    override fun onCleared() {
        super.onCleared()
        repository.cancelAllRequests()
    }
}