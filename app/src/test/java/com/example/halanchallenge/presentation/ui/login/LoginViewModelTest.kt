package com.example.halanchallenge.presentation.ui.login

import com.example.halanchallenge.data.LoginFakeRepository
import com.example.halanchallenge.data.utils.Resource
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.use_case.LoginUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {


    lateinit var loginUseCase: LoginUseCase
    private val loginRepository = LoginFakeRepository()
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        loginUseCase = LoginUseCase(loginRepository)
        loginViewModel = LoginViewModel(loginUseCase)
    }

    @Test
    fun `requestLoginCredentials() with correct login request then return resource success`() = runBlocking {
        //Arrange
        val loginRequest = LoginRequest()
        loginRequest.loginUserName = "asdasd"
        loginRequest.loginPassword = "123"

        //Act
        val result =
            loginUseCase.requestLoginCredentials(loginRequest) //Resource (Success , Failed)


        //Assert
        assert(result is Resource.Success)
    }
    @Test
    fun `requestLoginCredentials() with wrong login request then return resource failed`() = runBlocking {
        //Arrange
        val loginRequest = LoginRequest()
        loginRequest.loginUserName = "asd"
        loginRequest.loginPassword = "123"

        //Act
        val result =
            loginUseCase.requestLoginCredentials(loginRequest) //Resource (Success , Failed)

        //Assert
        assert(result is Resource.Failed)
    }

    @Test
    fun `isCorrectUserNameLength() with correct user name then return true`() {
        //Arrange:
        val userName = "Ahmeed"

        //Act:
        val result = loginViewModel.isCorrectUserNameLength(userName)

        //Assert
        assertThat(result).isTrue()
    }

    @Test
    fun `isCorrectUserNameLength() with empty user name then return false`() {
        //Arrange:
        val userName = ""

        //Act:
        val result = loginViewModel.isCorrectUserNameLength(userName)

        //Assert
        assertThat(result).isFalse()
    }

    @Test
    fun `isCorrectUserNameLength() with less than 6 user name then return false`() {
        //Arrange:
        val userName = "aaa"

        //Act:
        val result = loginViewModel.isCorrectUserNameLength(userName)

        //Assert
        assertThat(result).isFalse()
    }

    @Test
    fun `isCorrectUserNameLength() with more than 15 user name then return false`() {
        //Arrange:
        val userName = "aaaaaaaaaaaaaaaa"

        //Act:
        val result = loginViewModel.isCorrectUserNameLength(userName)

        //Assert
        assertThat(result).isFalse()
    }

    @Test
    fun `isCorrectPasswordLength() with correct password then return true`() {
        //Arrange:
        val password = "123"

        //Act:
        val result = loginViewModel.isCorrectPasswordLength(password)

        //Assert
        assertThat(result).isTrue()
    }

    @Test
    fun `isCorrectPasswordLength() with empty password then return false`() {
        //Arrange:
        val password = ""

        //Act:
        val result = loginViewModel.isCorrectPasswordLength(password)

        //Assert
        assertThat(result).isFalse()
    }

    @Test
    fun `isCorrectAlphanumeric() with correct user name then return true`() {
        //Arrange:
        val userName = "123aaa"

        //Act:
        val result = loginViewModel.isCorrectAlphanumeric(userName)

        //Assert
        assertThat(result).isTrue()
    }




}