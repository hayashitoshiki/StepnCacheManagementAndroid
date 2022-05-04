package com.myapp.domain.usecase

import com.myapp.model.value.StepnCoin

interface CoinUseCase {
    fun updateWalletCoin(coin: StepnCoin)
    fun updateSpendingCoin(coin: StepnCoin)
    fun updateRateCoin(coin: StepnCoin)
}