package com.example.halanchallenge.domain.model.product

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.halanchallenge.BR
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class Product:BaseObservable(), Parcelable {

    @IgnoredOnParcel
    @SerializedName("id")
    var productId = 0

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("name_ar")
    var productNameArabic: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productNameArabic)
        }

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("name_en")
    var productNameEnglish: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productNameEnglish)
        }

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("brand")
    var productBrand: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productBrand)
        }

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("price")
    var productPrice: Double = 0.0
        set(value) {
            field = value
            notifyPropertyChanged(BR.productPrice)
        }


    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("deal_description")
    var productDescription: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productDescription)
        }

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("image")
    var productImage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.productImage)
        }

    @IgnoredOnParcel
    @get:Bindable
    @SerializedName("images")
    var productDetailsImages: ArrayList<String>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.productDetailsImages)
        }
}