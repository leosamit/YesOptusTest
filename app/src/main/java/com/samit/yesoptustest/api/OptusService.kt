package com.samit.yesoptustest.api

import com.samit.yesoptustest.api.ApiKeys.Companion.API_GET_USERS
import retrofit2.Response
import retrofit2.http.GET

interface OptusService {
    @GET(API_GET_USERS)
    suspend fun getUsers(): Response<List<OptusApi>>
}