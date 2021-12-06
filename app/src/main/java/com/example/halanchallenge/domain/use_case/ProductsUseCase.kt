package com.example.halanchallenge.domain.use_case

import com.example.halanchallenge.data.utils.BaseDataSource
import com.example.halanchallenge.domain.model.product.ProductGateway
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val productsRepository: ProductGateway
) : BaseDataSource() {

    suspend fun getProducts(userToken: String) =
        safeApiCall { productsRepository.requestProducts(userToken) }
}