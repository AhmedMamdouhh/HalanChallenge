package com.example.halanchallenge.domain.model.product

import retrofit2.Response

interface ProductGateway {
    suspend fun requestProducts(
        userToken: String
    ): Response<ProductsResponse>
}