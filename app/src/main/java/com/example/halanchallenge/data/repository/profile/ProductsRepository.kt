package com.example.halanchallenge.data.repository.profile

import com.example.halanchallenge.data.remote.Api
import com.example.halanchallenge.domain.model.product.ProductGateway
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val api: Api
) : ProductGateway {

    override suspend fun requestProducts(userToken: String) =
        api.getProducts(userToken)
}