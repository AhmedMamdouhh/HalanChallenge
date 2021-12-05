package com.example.halanchallenge.domain.model.login

import com.example.halanchallenge.domain.model.user.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val token: String,
    @SerializedName("profile")
    val profile: User
)