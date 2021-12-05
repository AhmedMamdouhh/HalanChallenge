package com.example.halanchallenge.presentation.utils.manager

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var responseManager: ResponseManager

    @Inject
    @ApplicationContext
    lateinit var context: Context

}