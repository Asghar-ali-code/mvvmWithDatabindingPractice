package com.asghar.mvvm.data.network

import com.asghar.mvvm.data.model.Login
import com.asghar.mvvm.data.model.LoginModel

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
  @POST("api/customer/login")
    fun login(
        @Field("email")  email:String,
        @Field("password")  password:String,
        @Field("device_token") device_token:String
    ):Call<Login>
    @FormUrlEncoded
    @POST("provider/login")
    fun loginUser(
        @Field("username") email: String,
        @Field("password") pass: String,
        @Field("device_token") device_token: String
    ): Call<LoginModel>
}