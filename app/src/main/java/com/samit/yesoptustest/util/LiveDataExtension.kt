package com.samit.yesoptustest.util

import androidx.lifecycle.MutableLiveData
import com.samit.yesoptustest.data.Result

fun <T> MutableLiveData<Result<T>>.postSuccess(data: T) =
    postValue(Result.success(data))

fun <T> MutableLiveData<Result<T>>.postLoading() =
    postValue(Result.loading(value?.data))

fun <T> MutableLiveData<Result<T>>.postError(errorMessage: String) {
    postValue(Result.error(errorMessage))
}