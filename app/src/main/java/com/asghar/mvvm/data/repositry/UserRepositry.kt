package com.asghar.mvvm.data.repositry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.asghar.mvvm.data.model.LoginModel
import com.asghar.mvvm.data.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepositry @Inject constructor(
    val  providerMyApi: MyApi
)  {
    val TAG="UserRepositry"
    fun userLogin(
        email: String,
        password: String,
        deviceToken: String,
    ): MutableLiveData<LoginModel> {
        var loginRespone = MutableLiveData<LoginModel>()
      //val call= RetrofitClient().getClientRetro(context)?.create(MyApi::class.java)
        /*val call=AppModule.provideMyApi(retrofitClient)*/
        val call=providerMyApi
          call?.loginUser(email,password,deviceToken)?.enqueue(object :Callback<LoginModel>{
              override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
if (response.body()?.code.equals("200")){
    loginRespone.value=response.body()
    Log.e(TAG, "onResponse: "+response.body()?.message )

}else {
    loginRespone.value=response.body()
    Log.e(TAG, "onResponse: else "+response.body()?.message )
}
              }

              override fun onFailure(call: Call<LoginModel>, t: Throwable) {

                  Log.e(TAG, "onResponse: "+t.message )
              }
          })
        return loginRespone
    }
}


