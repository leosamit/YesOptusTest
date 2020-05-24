package com.samit.yesoptustest.api

import com.google.gson.annotations.SerializedName

import com.samit.yesoptustest.api.ApiKeys.Companion.ID

data class OptusApi(
    @SerializedName(ID)
    val id: Int? = null
)

interface ApiKeys {
    companion object {
        const val ID = "id"
        const val API_GET_JSON = "sample.json"
        const val ENDPOINT = "http://express-it.optusnet.com.au/"
    }
}