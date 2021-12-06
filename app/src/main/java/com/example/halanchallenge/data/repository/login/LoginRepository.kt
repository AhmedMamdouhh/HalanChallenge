package com.example.halanchallenge.data.repository.login

import com.example.halanchallenge.data.remote.Api
import com.example.halanchallenge.data.utils.BaseDataSource
import com.example.halanchallenge.domain.model.login.LoginGateway
import com.example.halanchallenge.domain.model.login.LoginRequest
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: Api
) : LoginGateway{

    override suspend fun requestLogin(loginRequest: LoginRequest) =
         api.getLoginData(loginRequest)

}