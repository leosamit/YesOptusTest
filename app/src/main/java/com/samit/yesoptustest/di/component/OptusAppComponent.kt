package com.samit.yesoptustest.di.component

import android.app.Application
import com.samit.yesoptustest.OptusApp
import com.samit.yesoptustest.di.builder.ActivityBuilder
import com.samit.yesoptustest.di.module.AppModule
import com.samit.yesoptustest.di.module.ContextModule
import com.samit.yesoptustest.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ContextModule::class,
        ActivityBuilder::class]
)
interface OptusAppComponent : AndroidInjector<OptusApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): OptusAppComponent
    }
}