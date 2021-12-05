package com.example.halanchallenge.data.remote

import com.example.halanchallenge.BuildConfig
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    //Login
    @POST("auth")
    suspend fun getLoginData(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>



}