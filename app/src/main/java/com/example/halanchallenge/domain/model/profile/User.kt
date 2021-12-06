package com.example.halanchallenge.domain.model.profile

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.halanchallenge.BR
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class User : BaseObservable(), Parcelable {


    @get:Bindable
    @IgnoredOnParcel
    @SerializedName("username")
    var userNickName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userNickName)
        }

    @get:Bindable
    @IgnoredOnParcel
    @SerializedName("image")
    var userImage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userImage)
        }

    @get:Bindable
    @IgnoredOnParcel
    @SerializedName("name")
    var userName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userName)
        }

    @get:Bindable
    @IgnoredOnParcel
    @SerializedName("phone")
    var userPhone: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userPhone)
        }

    @get:Bindable
    @IgnoredOnParcel
    @SerializedName("email")
    var userEmail: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userEmail)
        }
}