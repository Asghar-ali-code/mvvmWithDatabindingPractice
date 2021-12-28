package com.asghar.mvvm.modelViewM

interface AuthListner {
    fun onStarted()
    fun onComplete()
    fun onError(error:String)
}