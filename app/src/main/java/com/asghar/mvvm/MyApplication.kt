package com.asghar.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {
    private var me: MyApplication? = null

    override fun onCreate() {
        super.onCreate()
        me = this
    }

    fun getInstance(): MyApplication? {
        return me
    }
}
