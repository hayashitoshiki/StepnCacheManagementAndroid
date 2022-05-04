package com.myapp.domain.usecase

import com.myapp.domain.repository.LocalCoinRepository
import com.myapp.model.entity.Spending
import com.myapp.model.entity.StepnCoinRate
import com.myapp.model.entity.Wallet
import com.myapp.model.value.*
import javax.inject.Inject

class CoinUseCaseImpl@Inject constructor(
    private val localCoinRepository: LocalCoinRepository
) : CoinUseCase {

    override fun getWalletCoin(): Wallet {
        return localCoinRepository.getWalletCoin()
    }

    override fun getSpendingCoin(): Spending {
        return localCoinRepository.getSpendingCoin()
    }

    override fun getRateCoin(): StepnCoinRate {
        return localCoinRepository.getRateCoin()
    }

    override fun updateWalletCoin(coin: StepnCoin) {
        when(coin) {
            is GmtCoin -> localCoinRepository.updateWalletGmt(coin)
            is GstCoin -> localCoinRepository.updateWalletGst(coin)
            is SolanaCoin -> localCoinRepository.updateWalletSol(coin)
            is UsdcCoin -> localCoinRepository.updateWalletUsdc(coin)
        }
    }

    override fun updateSpendingCoin(coin: StepnCoin) {
        when(coin) {
            is GmtCoin -> localCoinRepository.updateSpendingGmt(coin)
            is GstCoin -> localCoinRepository.updateSpendingGst(coin)
            is SolanaCoin -> localCoinRepository.updateSpendingSol(coin)
            is UsdcCoin -> throw IllegalAccessError("SpendingはUSDCには存在しません。")
        }
    }

    override fun updateRateCoin(coin: StepnCoin) {
        when(coin) {
            is GmtCoin -> localCoinRepository.updateRateGmt(coin)
            is GstCoin -> localCoinRepository.updateRateGst(coin)
            is SolanaCoin -> localCoinRepository.updateRateSol(coin)
            is UsdcCoin -> localCoinRepository.updateRateUsdc(coin)
        }
    }
}