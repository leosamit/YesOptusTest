package com.samit.yesoptustest.di.module


import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.samit.yesoptustest.api.ApiKeys.Companion.ENDPOINT
import com.samit.yesoptustest.api.OptusService
import com.samit.yesoptustest.data.repo.Repository
import com.samit.yesoptustest.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(ENDPOINT)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
            .addNetworkInterceptor(StethoInterceptor())
        return client.build()
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): OptusService {
        return retrofit.create(OptusService::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(service: OptusService) =
        RemoteDataSource(service)

    @Singleton
    @Provides
    fun provideRepository() = Repository()

  /*  @Singleton
    @Provides
    fun provideTransportRepository() = TransportRepository()*/

}