package com.example.halanchallenge.presentation.ui.product_details.images_banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.databinding.ItemImageBinding

class ImagesBannerAdapter(
    private val imagesBannerList: ArrayList<String>
) : RecyclerView.Adapter<ImagesBannerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesBannerViewHolder =
        ImagesBannerViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ImagesBannerViewHolder, position: Int) {
        holder.bind(imagesBannerList[position])
    }

    override fun getItemCount(): Int {
        return imagesBannerList.size
    }
}