package com.example.halanchallenge.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.halanchallenge.R
import com.example.halanchallenge.data.utils.Resource
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.model.login.LoginResponse
import com.example.halanchallenge.domain.model.profile.User
import com.example.halanchallenge.domain.use_case.LoginUseCase
import com.example.halanchallenge.presentation.utils.Constants
import com.example.halanchallenge.presentation.utils.Event
import com.example.halanchallenge.presentation.utils.manager.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
    ) : BaseViewModel() {

    private val _observeLoginSuccess = MutableLiveData<Event<LoginResponse>>()

    //Click:
    fun onLoginClicked(loginRequest: LoginRequest) {
        if (validation(loginRequest.loginUserName,loginRequest.loginPassword)) {
            responseManager.loading()
            viewModelScope.launch {
                when (val response = loginUseCase.requestLoginCredentials(loginRequest)) {
                    is Resource.Success -> {
                        responseManager.hideLoading()
                        _observeLoginSuccess.value = Event(response.data!!)
                    }
                    is Resource.Failed -> {
                        responseManager.hideLoading()
                        responseManager.failed(context.getString(R.string.error_general))
                    }
                    else -> responseManager.noConnection()
                }
            }
        }
    }

    //Validation:
    private fun validation(userName: String,password: String): Boolean {
        if(!isCorrectUserNameLength(userName)){
            responseManager.failed(context.getString(R.string.error_login_username_length))
            return false
        }
        if(!isCorrectAlphanumeric(userName)){
            responseManager.failed(context.getString(R.string.error_login_not_alphanumeric))
            return false
        }

        if(!isCorrectPasswordLength(password)){
            responseManager.failed(context.getString(R.string.error_login_password_length))
            return false
        }

        return true
    }
    fun isCorrectUserNameLength(userName: String):Boolean{
        if (userName.length >= Constants.USER_NAME_MIN_LENGTH
            && userName.length <= Constants.USER_NAME_MAX_LENGTH)
                return true
        return false
    }
    fun isCorrectPasswordLength(password:String):Boolean{
        if(password.trim().isEmpty())
            return false
        return true
    }
    fun isCorrectAlphanumeric(userName: String):Boolean{
        val regex = Regex("[A-Za-z0-9]*")
        return regex.matches(userName)
    }


    //Getters:
    val observeLoginSuccess: LiveData<Event<LoginResponse>>
        get() = _observeLoginSuccess
}