package com.asghar.mvvm.modelViewM

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel


class ModelViewM : ViewModel()  {
                  //Important notes
   /* model Class package name should be start with small letter
    class name should be start with Capital letter*/



    var email :String?=null
    var password:String?=null
    var authListner:AuthListner?=null

    fun btnlogin(view:View){
        Log.d("dhdhdhdh", "btnlogin: "+email)
        authListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            Log.d("dhdhdhdh", "btnlogin: "+password)
            authListner?.onError("Somethig wen wrong")


        }else{
            authListner?.onComplete()

        }

    }
}