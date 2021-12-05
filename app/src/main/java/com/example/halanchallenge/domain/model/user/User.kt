package com.example.halanchallenge.domain.model.user

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.halanchallenge.BR

class User : BaseObservable() {


    @get:Bindable
    var userFullName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userFullName)
        }

    @get:Bindable
    var userImage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userImage)
        }

    @get:Bindable
    var userName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userName)
        }

    @get:Bindable
    var userPhone: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userPhone)
        }

    @get:Bindable
    var userEmail: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.userEmail)
        }
}