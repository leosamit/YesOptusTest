package com.samit.yesoptustest.data.source

import com.samit.yesoptustest.api.BaseDataSource
import com.samit.yesoptustest.api.OptusService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: OptusService) :
    BaseDataSource() {
    suspend fun fetchUsers() = getResult {
        service.getUsers()
    }
}