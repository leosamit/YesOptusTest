package com.samit.yesoptustest.di.builder


import com.samit.yesoptustest.ui.scenario1.ScenarioOneFragment
import com.samit.yesoptustest.ui.scenario1.point2.SPointTwoFragment
import com.samit.yesoptustest.ui.scenario2.ScenarioTwoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideScenarioOneFragment(): ScenarioOneFragment

    @ContributesAndroidInjector
    abstract fun provideScenarioOnePointTwo(): SPointTwoFragment

    @ContributesAndroidInjector
    abstract fun provideScenarioTwoFragment(): ScenarioTwoFragment
}