package com.asghar.mvvm.modelViewM


import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.asghar.mvvm.data.model.LoginModel
import com.asghar.mvvm.data.repositry.UserRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
 class LoginViewModel @Inject constructor(
      val repositry:UserRepositry
) : ViewModel()  {
                  //Important notes
   /* model Class package name should be start with small letter
    class name should be start with Capital letter*/



    var email :String?=null
    var password:String?=null
    var authListner:AuthListner?=null

     private var respone: MutableLiveData<LoginModel>?=null;
    val TAG="modelViewM"

    fun btnlogin(view:View){
        Log.d("dhdhdhdh", "btnlogin: "+email)
        authListner?.onStarted()
        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()){

            authListner?.onComplete( repositry.
            userLogin(email!!,password!!,"123"))



        }else{
            authListner?.onError("Something went wrong")


        }

    }
}