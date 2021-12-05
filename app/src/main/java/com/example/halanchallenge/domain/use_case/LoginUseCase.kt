package com.example.halanchallenge.domain.use_case

import com.example.halanchallenge.data.repository.login.LoginRepositoryGateway
import com.example.halanchallenge.data.utils.BaseDataSource
import com.example.halanchallenge.domain.model.login.LoginRequest
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository:
    LoginRepositoryGateway
) : BaseDataSource() {

    suspend fun requestLoginCredentials(loginRequest: LoginRequest) =
        safeApiCall { loginRepository.requestLogin(loginRequest) }
}