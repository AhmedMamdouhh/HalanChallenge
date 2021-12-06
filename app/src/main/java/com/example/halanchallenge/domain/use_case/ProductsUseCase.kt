package com.example.halanchallenge.domain.use_case

import com.example.halanchallenge.data.repository.profile.ProductsRepository
import com.example.halanchallenge.data.utils.BaseDataSource
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) : BaseDataSource() {

    suspend fun getProducts(userToken: String) =
        safeApiCall { productsRepository.requestProducts(userToken) }
}