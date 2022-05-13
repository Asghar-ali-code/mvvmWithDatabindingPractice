package com.asghar.mvvm.dI.repositry

import com.asghar.mvvm.login.newtwork.LoginApi
import com.asghar.mvvm.login.repositry.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryProvider {

    @Provides
    fun loginRespositeryProvider(
        providerLoginApi: LoginApi
    ): UserRepository {
        return UserRepository(providerLoginApi)
    }

}