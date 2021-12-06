package com.example.halanchallenge.presentation.ui.profile.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemProductBinding
import com.example.halanchallenge.domain.model.product.Product
import com.example.halanchallenge.presentation.ui.profile.ProfileViewModel

class ProductsAdapter(
    private val productsList: ArrayList<Product>,
    private val profileViewModel: ProfileViewModel
) : RecyclerView.Adapter<ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder =
        ProductsViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), profileViewModel
        )

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}