package com.example.halanchallenge.data

import com.example.halanchallenge.domain.model.product.Product
import com.example.halanchallenge.domain.model.product.ProductGateway
import com.example.halanchallenge.domain.model.product.ProductsResponse
import retrofit2.Response

class ProfileFakeRepository:ProductGateway {

    override suspend fun requestProducts(userToken: String): Response<ProductsResponse> {
        val products = ArrayList<Product>()
        products.add(Product())
        products.add(Product())
        products.add(Product())
        products.add(Product())

        val productsResponse = ProductsResponse(products)

        return if(userToken.isNotEmpty())
            Response.success(productsResponse)
        else
            Response.success(null)
    }
}