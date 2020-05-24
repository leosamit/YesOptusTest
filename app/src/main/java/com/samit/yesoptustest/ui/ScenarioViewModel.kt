package com.samit.yesoptustest.ui

import androidx.lifecycle.ViewModel
import com.samit.yesoptustest.data.repo.Repository
import javax.inject.Inject

class ScenarioViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    val scenarios by lazy {
        repository.getScenarios()
    }
    val scenariosOneItems by lazy {
        repository.getScenarioOneItems()
    }
}