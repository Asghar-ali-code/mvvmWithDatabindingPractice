package com.asghar.mvvm.data.DI

import com.asghar.mvvm.Utiltiy.UtilityValues
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object OkHttpBuilder {

    @Provides
    fun OkHttpReturn(): OkHttpClient {
        val i = HttpLoggingInterceptor()
        i.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .connectTimeout(UtilityValues.TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(UtilityValues.TIME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(UtilityValues.TIME_OUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(i)
            .build()
    }


}