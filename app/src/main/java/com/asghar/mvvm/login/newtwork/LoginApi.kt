package com.asghar.mvvm.login.newtwork


import com.asghar.mvvm.login.model.LoginModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @FormUrlEncoded
    @POST("provider/login")
    suspend fun loginUser(
        @Field("username") email: String,
        @Field("password") pass: String,
        @Field("device_token") device_token: String
    ): Response<LoginModel>
}