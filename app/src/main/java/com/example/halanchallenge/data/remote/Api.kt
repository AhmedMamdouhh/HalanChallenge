package com.example.halanchallenge.data.remote

import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.domain.model.login.LoginResponse
import com.example.halanchallenge.domain.model.product.ProductsResponse
import retrofit2.Response
import retrofit2.http.*

interface Api {

    //Login
    @POST("auth")
    suspend fun getLoginData(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    //Profile products
    @GET("products")
    suspend fun getProducts(
        @Header("Authorization")
        token: String
    ): Response<ProductsResponse>

}