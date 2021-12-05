package com.example.halanchallenge.domain.use_case


import com.example.halanchallenge.data.LoginFakeRepository
import com.example.halanchallenge.data.utils.Resource
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.model.login.LoginResponse
import com.example.halanchallenge.domain.model.user.User
import com.example.halanchallenge.presentation.ui.login.LoginViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class LoginUseCaseTest{

    lateinit var loginUseCase: LoginUseCase
    private val loginRepository = LoginFakeRepository()

    @Before
    fun setup() {
        loginUseCase = LoginUseCase(loginRepository)
    }

    @Test
    fun `requestLoginCredentials() with login request object then return Resource of login response`() = runBlocking {
        //arrange:

    }
}