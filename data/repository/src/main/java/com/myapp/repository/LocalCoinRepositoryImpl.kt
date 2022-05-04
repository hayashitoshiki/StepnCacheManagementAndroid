package com.myapp.repository

import com.myapp.domain.repository.LocalCoinRepository
import com.myapp.local.preferences.PreferenceManager
import com.myapp.model.entity.Spending
import com.myapp.model.entity.StepnCoinRate
import com.myapp.model.entity.Wallet
import com.myapp.model.value.GmtCoin
import com.myapp.model.value.GstCoin
import com.myapp.model.value.SolanaCoin
import com.myapp.model.value.UsdcCoin
import javax.inject.Inject

class LocalCoinRepositoryImpl @Inject constructor(
    private val preferenceManager: PreferenceManager
): LocalCoinRepository {

    override fun getWalletCoin(): Wallet {
        val gst = GstCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.WALLET_GST))
        val gmt = GmtCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.WALLET_GMT))
        val sol = SolanaCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.WALLET_SOL))
        val usdc = UsdcCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.WALLET_USDC))
      return Wallet(gst, gmt, sol, usdc)
    }

    override fun getSpendingCoin(): Spending {
        val gst = GstCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.SPENDING_GST))
        val gmt = GmtCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.SPENDING_GMT))
        val sol = SolanaCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.SPENDING_SOL))
        return Spending(gst, gmt, sol)
    }

    override fun getRateCoin(): StepnCoinRate {
        val gst = GstCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.RATE_GST))
        val gmt = GmtCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.RATE_GMT))
        val sol = SolanaCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.RATE_SOL))
        val usdc = UsdcCoin(preferenceManager.getFloat(PreferenceManager.Key.FloatKey.RATE_USDC))
        return StepnCoinRate(gst, gmt, sol, usdc)
    }

    override fun updateWalletGmt(coin: GmtCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.WALLET_GMT, coin.value)
    }

    override fun updateWalletGst(coin: GstCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.WALLET_GST, coin.value)
    }

    override fun updateWalletSol(coin: SolanaCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.WALLET_SOL, coin.value)
    }

    override fun updateWalletUsdc(coin: UsdcCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.WALLET_USDC, coin.value)
    }

    override fun updateRateGmt(coin: GmtCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.RATE_GMT, coin.value)
    }

    override fun updateRateGst(coin: GstCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.RATE_GST, coin.value)
    }

    override fun updateRateSol(coin: SolanaCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.RATE_SOL, coin.value)
    }

    override fun updateRateUsdc(coin: UsdcCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.RATE_USDC, coin.value)
    }

    override fun updateSpendingGmt(coin: GmtCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.SPENDING_GMT, coin.value)
    }

    override fun updateSpendingGst(coin: GstCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.SPENDING_GST, coin.value)
    }

    override fun updateSpendingSol(coin: SolanaCoin) {
        preferenceManager.setFloat(PreferenceManager.Key.FloatKey.SPENDING_SOL, coin.value)
    }
}