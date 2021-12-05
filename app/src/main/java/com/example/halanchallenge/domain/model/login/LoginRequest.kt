package com.example.halanchallenge.domain.model.login

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.halanchallenge.BR
import com.google.gson.annotations.SerializedName

class LoginRequest :BaseObservable(){

    @get:Bindable
    @SerializedName("username")
    var loginUserName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.loginUserName)
        }

    @get:Bindable
    @SerializedName("password")
    var loginPassword: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.loginPassword)
        }

}