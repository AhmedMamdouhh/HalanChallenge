package com.example.halanchallenge.presentation.ui.profile

import com.example.halanchallenge.data.ProfileFakeRepository
import com.example.halanchallenge.data.utils.Resource
import com.example.halanchallenge.domain.use_case.ProductsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class ProfileViewModelTest{

    private lateinit var productsUseCase: ProductsUseCase
    private var profileFakeRepository = ProfileFakeRepository()
    private lateinit var profileViewModel: ProfileViewModel

    @Before
    fun setup(){
        productsUseCase = ProductsUseCase(profileFakeRepository)
        profileViewModel = ProfileViewModel(productsUseCase)
    }

    @Test
    fun `getProducts() with token then return success`() = runBlocking{
        //Arrange
        val token = "Token"

        //Act
        val result = productsUseCase.getProducts(token)

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getProducts() with empty token then return failed`() = runBlocking{
        //Arrange
        val token = ""

        //Act
        val result = productsUseCase.getProducts(token)

        //Assert
        assert(result is Resource.Failed)
    }

}