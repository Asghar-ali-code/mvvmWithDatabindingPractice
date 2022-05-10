package com.asghar.mvvm.data.network

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClientNew {
    private val URL =  "https://projects.funtash.net/technician/api/"
    private var retro: Retrofit? = null
    private val TIME_OUT = 3000


    fun getClientRetro(context: Context?): Retrofit? {
        if (retro == null) {
            val c = OkHttpClient.Builder()
            c.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            c.readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            c.writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            val i = HttpLoggingInterceptor()
            i.level = HttpLoggingInterceptor.Level.BODY
            c.addInterceptor(i)
            //  c.addInterceptor(NetworkConnectionInterceptor(context))
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retro = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(c.build())
                .build()
        }
        return retro
    }
}