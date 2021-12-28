package com.asghar.mvvm.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.asghar.mvvm.R
import com.asghar.mvvm.databinding.ActivityMainBinding
import com.asghar.mvvm.modelViewM.AuthListner
import com.asghar.mvvm.modelViewM.ModelViewM


class MainActivity : AppCompatActivity() ,AuthListner{
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        val viewModel=ViewModelProvider(this).get(ModelViewM::class.java)
       binding.viewModelM=viewModel
        viewModel.authListner=this
    }

    override fun onStarted() {
        Toast.makeText(this,"Started",Toast.LENGTH_SHORT).show()

    }

    override fun onComplete() {
        Toast.makeText(this,"Completed",Toast.LENGTH_SHORT).show()


    }

    override fun onError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()


    }
}