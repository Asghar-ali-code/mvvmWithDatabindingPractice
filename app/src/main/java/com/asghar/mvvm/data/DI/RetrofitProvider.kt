package com.asghar.mvvm.data.DI

import com.asghar.mvvm.Utiltiy.UtilityValues
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
object RetrofitProvider {

    @Provides
   fun retrofitReturn(c: OkHttpClient,gson:Gson):Retrofit{


        return Retrofit.Builder()
            .baseUrl(UtilityValues.URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(c)
            .build()

   }
}