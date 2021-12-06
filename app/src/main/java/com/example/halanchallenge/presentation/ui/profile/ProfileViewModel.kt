package com.example.halanchallenge.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.halanchallenge.R
import com.example.halanchallenge.data.utils.Resource
import com.example.halanchallenge.domain.model.product.Product
import com.example.halanchallenge.domain.use_case.ProductsUseCase
import com.example.halanchallenge.presentation.utils.Event
import com.example.halanchallenge.presentation.utils.manager.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
) :BaseViewModel() {

    private val _observeProductsList = MutableLiveData<Event<ArrayList<Product>>>()
    private val _observeProductClicked = MutableLiveData<Event<Product>>()

    fun getProducts(token:String){
        responseManager.loading()
        viewModelScope.launch {
            when (val response = productsUseCase.getProducts("Bearer $token")) {
                is Resource.Success -> {
                    responseManager.hideLoading()
                    _observeProductsList.value = Event(response.data!!.products)
                }
                is Resource.Failed -> {
                    responseManager.hideLoading()
                    responseManager.failed(context.getString(R.string.error_general))
                }
                else -> responseManager.noConnection()
            }
        }
    }

    //Click:
    fun onProductClicked(product:Product){ _observeProductClicked.value = Event(product) }

    //getters:
    val observeProductsList: LiveData<Event<ArrayList<Product>>>
        get() = _observeProductsList
    val observeProductClicked: LiveData<Event<Product>>
        get() = _observeProductClicked
}