package com.example.halanchallenge.domain.model.login

import com.example.halanchallenge.domain.model.profile.User

data class LoginResponse(
    val token: String,
    val profile: User
)