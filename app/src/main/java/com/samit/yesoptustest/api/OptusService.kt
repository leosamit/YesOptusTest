package com.samit.yesoptustest.api

import com.samit.yesoptustest.api.ApiKeys.Companion.API_GET_JSON
import retrofit2.Response
import retrofit2.http.GET

interface OptusService {
    @GET(API_GET_JSON)
    suspend fun getJson(): Response<List<OptusApi>>
}