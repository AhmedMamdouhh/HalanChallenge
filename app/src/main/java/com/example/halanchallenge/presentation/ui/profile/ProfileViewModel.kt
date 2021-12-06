package com.example.halanchallenge.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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

    fun getProducts(token:String){
        responseManager.loading()
        viewModelScope.launch {
            val response = productsUseCase.getProducts("Bearer $token")

            if(response is Resource.Success){
                responseManager.hideLoading()
                _observeProductsList.value = Event(response.data!!.products)
            }else if (response is Resource.Failed){
                responseManager.hideLoading()
            }
        }
    }

    //Click:
    fun onLogoutClicked(){

    }

    fun onMoreClicked(productId:Int){

    }

    //getters:
    val observeProductsList: LiveData<Event<ArrayList<Product>>>
        get() = _observeProductsList
}