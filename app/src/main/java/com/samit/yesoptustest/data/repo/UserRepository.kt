package com.samit.yesoptustest.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.samit.yesoptustest.data.OptusUI
import com.samit.yesoptustest.data.Result
import com.samit.yesoptustest.data.mapper.toOptustUI
import com.samit.yesoptustest.data.source.RemoteDataSource
import com.samit.yesoptustest.util.CoroutineDispatcherProvider
import com.samit.yesoptustest.util.postError
import com.samit.yesoptustest.util.postLoading
import com.samit.yesoptustest.util.postSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val remoteSource: RemoteDataSource,
    dispatcherProvider: CoroutineDispatcherProvider
) {
    private val _optusLivedata: MutableLiveData<Result<List<OptusUI>>> =
        MutableLiveData()
    var usersList: LiveData<Result<List<OptusUI>>> = _optusLivedata

    private val parentJob = Job()
    private val scope = CoroutineScope(dispatcherProvider.mainDispatcher + parentJob)

    fun getUsers() {
        _optusLivedata.postLoading()
        scope.launch {
            val responseStatus = remoteSource.fetchUsers()
            when (responseStatus.status) {
                Result.Status.SUCCESS -> {
                    _optusLivedata.postSuccess(responseStatus.data!!.map { toOptustUI(it) })
                }
                Result.Status.ERROR -> {
                    _optusLivedata.postError(responseStatus.message.toString())
                }
            }
        }
    }

    //Cancel Coroutine scope
    fun cancelAllRequests() {
        parentJob.cancelChildren()
    }
}