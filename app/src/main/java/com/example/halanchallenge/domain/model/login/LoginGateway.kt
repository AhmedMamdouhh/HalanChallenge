package com.example.halanchallenge.domain.model.login

import retrofit2.Response

interface LoginGateway {
    suspend fun
            requestLogin(loginRequest: LoginRequest):
            Response<LoginResponse>
}