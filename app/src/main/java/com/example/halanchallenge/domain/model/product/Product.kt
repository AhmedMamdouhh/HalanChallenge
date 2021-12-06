package com.example.halanchallenge.domain.model.product

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.halanchallenge.BR
import com.google.gson.annotations.SerializedName

class Product:BaseObservable() {

    @SerializedName("id")
    var productId = 0

    @get:Bindable
    @SerializedName("name_ar")
    var productNameArabic: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productNameArabic)
        }

    @get:Bindable
    @SerializedName("name_en")
    var productNameEnglish: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productNameEnglish)
        }

    @get:Bindable
    @SerializedName("brand")
    var productBrand: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productBrand)
        }

    @get:Bindable
    @SerializedName("price")
    var productPrice: Double = 0.0
        set(value) {
            field = value
            notifyPropertyChanged(BR.productPrice)
        }


    @get:Bindable
    @SerializedName("deal_description")
    var productDescription: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productDescription)
        }

    @get:Bindable
    @SerializedName("image")
    var productImage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productImage)
        }

    @get:Bindable
    @SerializedName("images")
    var productDetailsImages: ArrayList<String>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.productDetailsImages)
        }
}