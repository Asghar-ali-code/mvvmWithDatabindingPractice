package com.asghar.mvvm


import android.app.Application
import android.content.Context
import android.widget.Toast
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication: Application() {

    companion object{
        lateinit var  myAppContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        myAppContext = baseContext
    }





}
