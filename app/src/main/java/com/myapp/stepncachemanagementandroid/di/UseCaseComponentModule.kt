package com.myapp.stepncachemanagementandroid.di

import com.myapp.domain.usecase.CoinUseCase
import com.myapp.domain.usecase.CoinUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseComponentModule {

    @Binds
    abstract fun bindCoinUseCase(coinUseCase: CoinUseCaseImpl): CoinUseCase

}