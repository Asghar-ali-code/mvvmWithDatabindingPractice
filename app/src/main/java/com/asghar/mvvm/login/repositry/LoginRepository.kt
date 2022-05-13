package com.asghar.mvvm.login.repositry

import com.asghar.mvvm.utiltiy.BaseDataSource
import com.asghar.mvvm.utiltiy.Resource
import com.asghar.mvvm.login.model.LoginModel
import com.asghar.mvvm.login.newtwork.LoginApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface RepoRepository {
    fun getRepoList(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<Resource<LoginModel>>

}

class UserRepository @Inject constructor(
    private val providerLoginApi: LoginApi
) : BaseDataSource(), RepoRepository {


    override fun getRepoList(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<Resource<LoginModel>> = flow {
        emit(Resource.loading(null))
        val response = safeApiCall {
            providerLoginApi.loginUser(email, password, deviceToken)

        }
        emit(response)

    }

}



