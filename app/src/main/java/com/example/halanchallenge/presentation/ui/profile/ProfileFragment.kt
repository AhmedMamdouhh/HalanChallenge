package com.example.halanchallenge.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.halanchallenge.databinding.FragmentProfileBinding
import com.example.halanchallenge.presentation.ui.profile.products.ProductsAdapter
import com.example.halanchallenge.presentation.utils.EventObserver
import com.example.halanchallenge.presentation.utils.recyclerAnimationExtension
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var profileBinding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var productsAdapter: ProductsAdapter
    private val userObjectArgs: ProfileFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileBinding = FragmentProfileBinding.inflate(inflater, container, false)

        profileBinding.userObject = userObjectArgs.userObject
        profileBinding.profileListener = profileViewModel

        profileViewModel.getProducts(userObjectArgs.userToken)

        observeProductsList()
        observeProductClicked()

        return profileBinding.root
    }

    private fun observeProductClicked() {
        profileViewModel.observeProductClicked.observe(
            viewLifecycleOwner,
            EventObserver { product ->
                val productDetails =
                    ProfileFragmentDirections.actionProfileFragmentToProductDetailsDialog(product)
                findNavController().navigate(productDetails)
            })
    }

    private fun observeProductsList() {
        profileViewModel.observeProductsList.observe(viewLifecycleOwner, EventObserver {
            productsAdapter = ProductsAdapter(it, profileViewModel)
            profileBinding.apply {
                rvProfileProductsList.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = productsAdapter
                    recyclerAnimationExtension(this)
                }
            }
        })
    }
}