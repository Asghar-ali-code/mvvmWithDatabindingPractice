package com.asghar.mvvm.data.DI

import com.asghar.mvvm.data.network.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
 object AppModule {
    @Provides
    fun provideMyApi(retrofit: Retrofit): MyApi {
        return retrofit.create(MyApi::class.java)
       /* @Provides
        fun provideViewModel(): ModelViewM{
           // return   ViewModelProvider(MainActivity::class.java).get(ModelViewM::class.java)
        }
*/


    }

}