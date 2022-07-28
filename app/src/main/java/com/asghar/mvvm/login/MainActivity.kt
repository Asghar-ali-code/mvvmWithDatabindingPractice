package com.asghar.mvvm.login


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.asghar.mvvm.BuildConfig
import com.asghar.mvvm.R
import com.asghar.mvvm.databinding.ActivityMainBinding
import com.asghar.mvvm.login.model.LoginDataModel
import com.asghar.mvvm.login.viewModel.LoginViewModel
import com.asghar.mvvm.utiltiy.Resource
import com.asghar.mvvm.utiltiy.SnacksBar
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
   val local= BuildConfig.URL


    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var date = "Mar 10, 2016 6:30:00 PM"
        var spf = SimpleDateFormat("MMM dd, yyyy hh:mm:ss aaa")
        val newDate: Date = spf.parse(date)
        spf = SimpleDateFormat("dd MMM yyyy")
        date = spf.format(newDate)
        println(date)

        initiateBinding()
        observeLoginNavigate()


    }

    private fun initiateBinding() {
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModelM = this@MainActivity.viewModel
            loginDataModel = this@MainActivity.viewModel.loginDataModel

        }

    }


    private fun observeLoginNavigate() {
        this@MainActivity.viewModel.loinUiModel.observe(this) {

            Log.e(TAG, "handleLoginNavigate: " + it?.data?.code)


            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    when (it.data?.code) {
                        "200" -> {
                            Log.e(TAG, "handleLoginNavigate: " + it.data.message)
                            binding.password.setText("")
                            binding.email.setText("")
                            viewModel.loginDataModel = LoginDataModel("", "")

                        }
                        "201" -> {
                            SnacksBar.errorSnackBar(binding.root, it.data.message, this)


                        }
                    }

                    // Handel Accordingly
                }
                Resource.Status.ERROR -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    it.message?.let { it1 -> SnacksBar.errorSnackBar(binding.root, it1, this) }

                    // Hide Loader
                    // Show appropriate message
                }
                Resource.Status.LOADING -> {
                    binding.progressbar.visibility = View.VISIBLE
                    //Show Loader
                }
                Resource.Status.FAILURE -> {
                    binding.progressbar.visibility = View.INVISIBLE
                    it.message?.let { it1 -> SnacksBar.errorSnackBar(binding.root, it1, this) }
                }

            }


        }
    }


}