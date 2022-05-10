package com.asghar.mvvm.Ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import com.asghar.mvvm.R
import com.asghar.mvvm.data.model.LoginModel
import com.asghar.mvvm.databinding.ActivityMainBinding
import com.asghar.mvvm.modelViewM.AuthListner
import com.asghar.mvvm.modelViewM.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AuthListner {
    lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"

    /*private val modelViewM:ModelViewM by viewModels()*/
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initiateBinding()

    }

    private fun initiateBinding() {
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main);
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModelM = this@MainActivity.viewModel
        }
        with(viewModel) {
            authListner = this@MainActivity

        }

    }

    override fun onStarted() {

        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show()

    }

    override fun onComplete(mutableLiveData: MutableLiveData<LoginModel>) {
        mutableLiveData.observe(this, Observer {
            Log.e(TAG, "onComplete: " + it.message)
            if (it.code.equals("200")) {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

            }
        })


    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()


    }
}