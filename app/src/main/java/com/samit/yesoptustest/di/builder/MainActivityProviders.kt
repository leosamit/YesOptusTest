package com.samit.yesoptustest.di.builder


import com.samit.yesoptustest.ui.ScenarioFragment
import com.samit.yesoptustest.ui.scenario1.ScenarioOneFragment
import com.samit.yesoptustest.ui.scenario2.ScenarioTwoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideScenarioHomeFragment(): ScenarioFragment

    @ContributesAndroidInjector
    abstract fun provideScenarioOneFragment(): ScenarioOneFragment

    @ContributesAndroidInjector
    abstract fun provideScenarioTwoFragment(): ScenarioTwoFragment
}