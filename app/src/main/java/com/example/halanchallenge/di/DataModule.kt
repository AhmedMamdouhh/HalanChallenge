package com.example.halanchallenge.di

import com.example.halanchallenge.data.remote.Api
import com.example.halanchallenge.data.repository.login.LoginRepository
import com.example.halanchallenge.data.repository.login.LoginRepositoryGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesLoginRepository(api: Api): LoginRepositoryGateway =
        LoginRepository(api)

}