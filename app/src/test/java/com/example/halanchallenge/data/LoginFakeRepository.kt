package com.example.halanchallenge.data

import com.example.halanchallenge.domain.model.login.LoginGateway
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.model.login.LoginResponse
import com.example.halanchallenge.domain.model.profile.User
import retrofit2.Response

class LoginFakeRepository : LoginGateway {

    override suspend fun requestLogin(loginRequest: LoginRequest): Response<LoginResponse> {

       val loginResponse = LoginResponse(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFzZGFzZCIsImltYWdlIjoiaHR0cHM6Ly9pLnBpY3N1bS5waG90b3MvaWQvMTA2Mi81MDkyLzMzOTUuanBnP2htYWM9bzltN3FlVTUxdU9MZlh2ZXBYY1RyazJaUGlTQkpFa2lpT3AtUXZ4amEtayIsIm5hbWUiOiLZgtin2K_YsSDZhdit2KjZiNioIiwiZW1haWwiOiI0YmljMjNpMmw1Nmk1dTFAZ21haWwuY29tIiwicGhvbmUiOiIwMTkxMDgzMDI1OSIsImlhdCI6MTYzODYzNDg2MiwiZXhwIjoxNjM4NjM1NzkyfQ.WYXagKSP1_WjIrvFpevQYDRwKZ3xOCZrPKPVn7PKd6w",
            User()
        )

        return if(loginRequest.loginUserName == "asdasd")
            Response.success(loginResponse)
        else
            Response.success(null)
    }
}