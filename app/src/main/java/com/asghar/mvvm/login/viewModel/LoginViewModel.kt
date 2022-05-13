package com.asghar.mvvm.login.viewModel

import androidx.lifecycle.*
import com.asghar.mvvm.utiltiy.Resource
import com.asghar.mvvm.login.model.LoginDataModel
import com.asghar.mvvm.login.model.LoginModel
import com.asghar.mvvm.login.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import androidx.lifecycle.asLiveData

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginLoginUseCase: LoginUseCase
) : ViewModel() {

    var loginDataModel = LoginDataModel()
    private var loginAction: MutableLiveData<Unit> = MutableLiveData()

    private val _loginUiModel = Transformations.switchMap(loginAction) {
        loginLoginUseCase(loginDataModel).asLiveData()
    }
    val loinUiModel: LiveData<Resource<LoginModel?>> = _loginUiModel

    fun btnLogin() {
        loginAction.value = Unit
    }


}