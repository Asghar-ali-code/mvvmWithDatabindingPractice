package com.asghar.mvvm.dI.usecase

import com.asghar.mvvm.login.repositry.UserRepository
import com.asghar.mvvm.login.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseProvider {

    @ViewModelScoped
    @Provides
    fun loginUseCaseProvider(
        repository: UserRepository

    ): LoginUseCase {
        return LoginUseCase(
            repository,
            Dispatchers.IO
        )
    }
}
