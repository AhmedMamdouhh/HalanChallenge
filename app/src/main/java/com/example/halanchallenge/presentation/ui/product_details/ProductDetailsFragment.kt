package com.example.halanchallenge.presentation.ui.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.halanchallenge.R
import com.example.halanchallenge.databinding.FragmentProductDetailsBinding
import com.example.halanchallenge.presentation.ui.product_details.images_banner.ImagesBannerAdapter
import com.example.halanchallenge.presentation.utils.manager.MainActivity

class ProductDetailsFragment : Fragment() {

    private lateinit var productDetailsBinding: FragmentProductDetailsBinding
    private val productDetailsDialogArgs: ProductDetailsFragmentArgs by navArgs()
    private lateinit var imagesBannerAdapter: ImagesBannerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        productDetailsBinding = FragmentProductDetailsBinding.inflate(inflater, container, false)

        productDetailsBinding.productObject = productDetailsDialogArgs.productObject
        productDetailsBinding.productDetailsListener = this
        initializeImagesBannerList()


        return productDetailsBinding.root
    }

    private fun initializeImagesBannerList() {
        imagesBannerAdapter = ImagesBannerAdapter(
            productDetailsDialogArgs.productObject.productDetailsImages!!
        )
        productDetailsBinding.apply {
            rvProductDetailsImagesList.apply {
                setHasFixedSize(true)
                layoutManager =
                    LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
                adapter = imagesBannerAdapter
            }
            productDetailsBinding.arProductDetailsIndicator.attachTo(
                rvProductDetailsImagesList,
                true
            )
        }
    }

    fun onBackClicked(){
        findNavController().navigateUp()
    }

}