package com.asghar.mvvm.data.DI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BaseUrl {
    @Provides
    fun baseUrlProvider():String{
        return "https://projects.funtash.net/technician/api"
    }
}