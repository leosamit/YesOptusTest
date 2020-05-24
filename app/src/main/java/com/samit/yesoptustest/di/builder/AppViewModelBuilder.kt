package com.samit.yesoptustest.di.builder

import androidx.lifecycle.ViewModel
import com.samit.yesoptustest.di.qualifier.ViewModelKey
import com.samit.yesoptustest.ui.ScenarioViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelBuilder {
    @Binds
    @IntoMap
    @ViewModelKey(ScenarioViewModel::class)
    abstract fun bindScenarioViewModel(scenarioViewModel: ScenarioViewModel): ViewModel
}