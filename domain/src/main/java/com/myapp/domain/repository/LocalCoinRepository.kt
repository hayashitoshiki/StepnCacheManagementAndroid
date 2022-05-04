package com.myapp.domain.repository

import com.myapp.model.entity.Spending
import com.myapp.model.entity.StepnCoinRate
import com.myapp.model.entity.Wallet
import com.myapp.model.value.*

/**
 * STEP'Nのコインに関するローカルCRUD処理
 *
 */
interface LocalCoinRepository {

    fun getWalletCoin() : Wallet
    fun getSpendingCoin() : Spending
    fun getRateCoin() : StepnCoinRate

    fun updateWalletGmt(coin: GmtCoin)
    fun updateWalletGst(coin: GstCoin)
    fun updateWalletSol(coin: SolanaCoin)
    fun updateWalletUsdc(coin: UsdcCoin)

    fun updateRateGmt(coin: GmtCoin)
    fun updateRateGst(coin: GstCoin)
    fun updateRateSol(coin: SolanaCoin)
    fun updateRateUsdc(coin: UsdcCoin)

    fun updateSpendingGmt(coin: GmtCoin)
    fun updateSpendingGst(coin: GstCoin)
    fun updateSpendingSol(coin: SolanaCoin)

}