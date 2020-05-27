package com.samit.yesoptustest.api

import com.google.gson.annotations.SerializedName
import com.samit.yesoptustest.api.ApiKeys.Companion.ID
import com.samit.yesoptustest.api.ApiKeys.Companion.NAME

data class OptusApi(
    @SerializedName(ID)
    val id: Int? = null,
    @SerializedName(NAME)
    val name: String? = null
)

interface ApiKeys {
    companion object {
        const val ID = "id"
        const val NAME = "name"
        const val API_GET_USERS = "users"
        const val ENDPOINT = "https://jsonplaceholder.typicode.com/"
    }
}