package com.example.halanchallenge.di

import com.example.halanchallenge.data.remote.Api
import com.example.halanchallenge.data.repository.login.LoginRepository
import com.example.halanchallenge.data.repository.profile.ProductsRepository
import com.example.halanchallenge.domain.model.login.LoginGateway
import com.example.halanchallenge.domain.model.product.ProductGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun providesLoginRepository(api: Api): LoginGateway =
        LoginRepository(api)

    @Provides
    fun providesProductRepository(api: Api): ProductGateway =
        ProductsRepository(api)


}