package com.example.halanchallenge.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.halanchallenge.databinding.FragmentLoginBinding
import com.example.halanchallenge.domain.model.login.LoginRequest
import com.example.halanchallenge.presentation.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment :Fragment(){

    private lateinit var loginBinding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        loginBinding = FragmentLoginBinding.inflate(inflater,container,false)

        loginBinding.loginObject = LoginRequest()
        loginBinding.loginListener = loginViewModel

        observeLoginData()

        return loginBinding.root
    }

    private fun observeLoginData() {
        loginViewModel.observeLoginSuccess.observe(viewLifecycleOwner,EventObserver{

        })
    }
}