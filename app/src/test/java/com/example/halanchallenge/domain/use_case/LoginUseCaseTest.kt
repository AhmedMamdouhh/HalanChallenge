package com.example.halanchallenge.domain.use_case


import com.example.halanchallenge.data.LoginFakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

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