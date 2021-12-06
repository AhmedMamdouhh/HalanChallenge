package com.example.halanchallenge.presentation.ui.product_details.images_banner

import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemImageBinding

class ImagesBannerViewHolder(
    private val itemImageBinding: ItemImageBinding
) : RecyclerView.ViewHolder(itemImageBinding.root) {

    fun bind(image: String) {
        itemImageBinding.image = image
    }
}