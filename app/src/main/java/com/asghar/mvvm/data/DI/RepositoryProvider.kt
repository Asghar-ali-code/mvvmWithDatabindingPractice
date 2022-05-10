package com.asghar.mvvm.data.DI

import com.asghar.mvvm.data.network.MyApi
import com.asghar.mvvm.data.repositry.UserRepositry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProvider {

    @Provides
    fun userRespositery(
        providerMyApi: MyApi
    ): UserRepositry {
        return UserRepositry(providerMyApi)

    }
}