package com.asghar.mvvm.modelViewM

import androidx.lifecycle.MutableLiveData
import com.asghar.mvvm.data.model.LoginModel

interface AuthListner {
    fun onStarted()
    fun onComplete(mutableLiveData: MutableLiveData<LoginModel>)
    fun onError(error:String)
}