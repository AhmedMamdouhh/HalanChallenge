package com.example.halanchallenge.presentation.ui.profile.products

import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemProductBinding
import com.example.halanchallenge.domain.model.product.Product
import com.example.halanchallenge.presentation.ui.profile.ProfileViewModel

class ProductsViewHolder(
    private val itemProductBinding: ItemProductBinding,
    private val profileViewModel: ProfileViewModel
): RecyclerView.ViewHolder(itemProductBinding.root) {

    fun bind(product:Product){
        itemProductBinding.productObject = product
        itemProductBinding.productListener = profileViewModel
    }
}