package com.asghar.mvvm.data.DI

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GsonProvider {
    @Provides
    fun gsongProvider():Gson{
return GsonBuilder()
    .setLenient()
    .create()
    }
}