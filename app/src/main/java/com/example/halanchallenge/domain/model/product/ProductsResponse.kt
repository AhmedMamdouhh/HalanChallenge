package com.example.halanchallenge.domain.model.product

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products")
    val products : ArrayList<Product>
)