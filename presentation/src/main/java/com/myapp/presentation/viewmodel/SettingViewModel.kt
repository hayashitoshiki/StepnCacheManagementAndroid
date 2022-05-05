package com.myapp.presentation.viewmodel

import com.myapp.composesample.util.base.BaseContract
import com.myapp.composesample.util.base.BaseViewModel
import com.myapp.domain.usecase.CoinUseCase
import com.myapp.model.value.*
import com.myapp.presentation.extension.changeStrValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 設定画面のUIロジック
 *
 */
@HiltViewModel
class SettingViewModel @Inject constructor(
    private val coinUseCase: CoinUseCase
) : BaseViewModel<SettingContract.State, SettingContract.Effect, SettingContract.Event>() {

    init {
        val wallet = coinUseCase.getWalletCoin()
        val spending = coinUseCase.getSpendingCoin()
        val rate = coinUseCase.getRateCoin()

        setState {
            copy(
                spendingGmt = spending.gmt.value.changeStrValue(),
                spendingGst = spending.gst.value.changeStrValue(),
                spendingSol = spending.sol.value.changeStrValue(),
                spendingGem = spending.gem.value.changeStrValue(),
                spendingShoebox = spending.shoebox.value.changeStrValue(),
                spendingSneaker = spending.sneaker.value.changeStrValue(),
                walletGmt = wallet.gmt.value.changeStrValue(),
                walletGst = wallet.gst.value.changeStrValue(),
                walletSol = wallet.sol.value.changeStrValue(),
                walletUsdc = wallet.usdc.value.changeStrValue(),
                walletGem = wallet.gem.value.changeStrValue(),
                walletShoebox = wallet.shoebox.value.changeStrValue(),
                walletSneaker = wallet.sneaker.value.changeStrValue(),
                rateGmt = rate.gmt.value.changeStrValue(),
                rateGst = rate.gst.value.changeStrValue(),
                rateSol = rate.sol.value.changeStrValue(),
                rateUsdc = rate.usdc.value.changeStrValue(),
                rateGem = rate.gem.value.changeStrValue(),
                rateShoebox = rate.shoebox.value.changeStrValue(),
                rateSneaker = rate.sneaker.value.changeStrValue(),
            )
        }
    }

    override fun initState(): SettingContract.State {
        return SettingContract.State()
    }

    override fun handleEvents(event: SettingContract.Event) = when(event) {
        is SettingContract.Event.OnUpdateRateAssets -> onUpdateRateCoin(event.type)
        is SettingContract.Event.OnUpdateWalletAssets -> onUpdateWalletCoin(event.type)
        is SettingContract.Event.OnUpdateSpendingAssets -> onUpdateSpendingCoin(event.type)
        is SettingContract.Event.OnChangeRateGmt -> onChangeRateGmt(event.coin)
        is SettingContract.Event.OnChangeRateGst -> onChangeRateGst(event.coin)
        is SettingContract.Event.OnChangeRateSol -> onChangeRateSol(event.coin)
        is SettingContract.Event.OnChangeRateUsdc -> onChangeRateUsdc(event.coin)
        is SettingContract.Event.OnChangeSpendingGmt -> onChangeSpendingGmt(event.coin)
        is SettingContract.Event.OnChangeSpendingGst -> onChangeSpendingGst(event.coin)
        is SettingContract.Event.OnChangeSpendingSol -> onChangeSpendingSol(event.coin)
        is SettingContract.Event.OnChangeWalletGmt -> onChangeWalletGmt(event.coin)
        is SettingContract.Event.OnChangeWalletGst -> onChangeWalletGst(event.coin)
        is SettingContract.Event.OnChangeWalletSol -> onChangeWalletSol(event.coin)
        is SettingContract.Event.OnChangeWalletUsdc -> onChangeWalletUsdc(event.coin)
        is SettingContract.Event.OnChangeRateGem -> onChangeRateGem(event.sol)
        is SettingContract.Event.OnChangeRateShoebox -> onChangeRateShoebox(event.sol)
        is SettingContract.Event.OnChangeRateSneaker -> onChangeRateSneaker(event.sol)
        is SettingContract.Event.OnChangeSpendingGem -> onChangeSpendingGem(event.count)
        is SettingContract.Event.OnChangeSpendingShoebox -> onChangeSpendingShoebox(event.count)
        is SettingContract.Event.OnChangeSpendingSneaker -> onChangeSpendingSneaker(event.count)
        is SettingContract.Event.OnChangeWalletGem -> onChangeWalletGem(event.count)
        is SettingContract.Event.OnChangeWalletShoebox -> onChangeWalletShoebox(event.count)
        is SettingContract.Event.OnChangeWalletSneaker -> onChangeWalletSneaker(event.count)
    }

    private fun changeCoinValue(value: String) : Float {
        return if (value.endsWith(".")) {
            (value + "0").toFloat()
        } else {
            value.toFloat()
        }
    }
    private fun checkCoinValueUpdate(value: String) : Boolean {
        val regexNumber = "[0-9.]{1,8}".toRegex()

        if (value.isEmpty()) return true
        if (value.startsWith(".")) return false
        if (!regexNumber.matches(value)) return false
        value.chunked(1)
            .filter { it == "." }
            .size
            .also{ if(it >= 2) return false }
        return true
    }

    private fun checkCountValueUpdate(value: String) : Boolean {
        val regexNumber = "[0-9]{1,8}".toRegex()

        if (value.isEmpty()) return true
        if (value.startsWith(".")) return false
        if (!regexNumber.matches(value)) return false
        return true
    }


    private fun onUpdateSpendingCoin(type: AssetsType) {
        val assets = when(type) {
            StepnCoinType.GMT -> {
                GmtCoin(changeCoinValue(state.value.spendingGmt))
            }
            StepnCoinType.GST -> {
               GstCoin(changeCoinValue(state.value.spendingGst))
            }
            StepnCoinType.SOL -> {
                SolanaCoin(changeCoinValue(state.value.spendingSol))
            }
            StepnCoinType.USCD -> {
               throw IllegalAccessError("SpendingはUSDCには存在しません。")
            }
            RealAssetsType.GEM -> {
                GemAssets(changeCoinValue(state.value.spendingGem))
            }
            RealAssetsType.SHOEBOX -> {
                ShoeboxAssets(changeCoinValue(state.value.spendingShoebox))
            }
            RealAssetsType.SNEAKER -> {
                SneakerAssets(changeCoinValue(state.value.spendingSneaker))
            }
        }
        coinUseCase.updateSpendingAssets(assets)
    }
    private fun onUpdateRateCoin(type: AssetsType) {
        val assets = when(type) {
            StepnCoinType.GMT -> {
                GmtCoin(changeCoinValue(state.value.rateGmt))
            }
            StepnCoinType.GST -> {
                GstCoin(changeCoinValue(state.value.rateGst))
            }
            StepnCoinType.SOL -> {
                SolanaCoin(changeCoinValue(state.value.rateSol))
            }
            StepnCoinType.USCD -> {
                UsdcCoin(changeCoinValue(state.value.rateUsdc))
            }
            RealAssetsType.GEM -> {
                GemAssets(changeCoinValue(state.value.rateGem))
            }
            RealAssetsType.SHOEBOX -> {
                ShoeboxAssets(changeCoinValue(state.value.rateShoebox))
            }
            RealAssetsType.SNEAKER -> {
                SneakerAssets(changeCoinValue(state.value.rateSneaker))
            }
        }
        coinUseCase.updateRateAssets(assets)
    }
    private fun onUpdateWalletCoin(type: AssetsType) {
        val assets = when(type) {
            StepnCoinType.GMT -> {
                GmtCoin(changeCoinValue(state.value.walletGmt))
            }
            StepnCoinType.GST -> {
                GstCoin(changeCoinValue(state.value.walletGst))
            }
            StepnCoinType.SOL -> {
                SolanaCoin(changeCoinValue(state.value.walletSol))
            }
            StepnCoinType.USCD -> {
                UsdcCoin(changeCoinValue(state.value.walletUsdc))
            }
            RealAssetsType.GEM -> {
                GemAssets(changeCoinValue(state.value.walletGem))
            }
            RealAssetsType.SHOEBOX -> {
                ShoeboxAssets(changeCoinValue(state.value.walletShoebox))
            }
            RealAssetsType.SNEAKER -> {
                SneakerAssets(changeCoinValue(state.value.walletSneaker))
            }
        }
        coinUseCase.updateWalletAssets(assets)
    }
    private fun onChangeSpendingGst(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(spendingGst = coin) }
    }
    private fun onChangeSpendingSol(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(spendingSol = coin) }
    }
    private fun onChangeSpendingGmt(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(spendingGmt = coin) }
    }
    private fun onChangeSpendingGem(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(spendingGem = assets) }
    }
    private fun onChangeSpendingShoebox(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(spendingShoebox = assets) }
    }
    private fun onChangeSpendingSneaker(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(spendingSneaker = assets) }
    }
    private fun onChangeRateGmt(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(rateGmt = coin) }
    }
    private fun onChangeRateGst(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(rateGst = coin) }
    }
    private fun onChangeRateSol(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(rateSol = coin) }
    }
    private fun onChangeRateUsdc(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(rateUsdc = coin) }
    }
    private fun onChangeRateGem(assets: String) {
        if (!checkCoinValueUpdate(assets)) return
        setState { copy(rateGem = assets) }
    }
    private fun onChangeRateShoebox(assets: String) {
        if (!checkCoinValueUpdate(assets)) return
        setState { copy(rateShoebox = assets) }
    }
    private fun onChangeRateSneaker(assets: String) {
        if (!checkCoinValueUpdate(assets)) return
        setState { copy(rateSneaker = assets) }
    }
    private fun onChangeWalletGmt(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(walletGmt = coin) }
    }
    private fun onChangeWalletGst(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(walletGst = coin) }
    }
    private fun onChangeWalletSol(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(walletSol = coin) }
    }
    private fun onChangeWalletUsdc(coin: String) {
        if (!checkCoinValueUpdate(coin)) return
        setState { copy(walletUsdc = coin) }
    }
    private fun onChangeWalletGem(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(walletGem = assets) }
    }
    private fun onChangeWalletShoebox(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(walletShoebox = assets) }
    }
    private fun onChangeWalletSneaker(assets: String) {
        if (!checkCountValueUpdate(assets)) return
        setState { copy(walletSneaker = assets) }
    }
}


/**
 * チャートサンプル画面 UI状態管理
 *
 */
interface SettingContract : BaseContract {

    /**
     * 状態保持
     *
     * @property spendingGmt SpendingのGMTコイン
     * @property spendingGst SpendingのGSTコイン
     * @property spendingSol SpendingのSolanaコイン
     * @property spendingGem SpendingのGem保持数
     * @property spendingShoebox SpendingのShoebox保持数
     * @property spendingSneaker SpendingのSneaker保持数
     * @property walletGmt WalletのGSTコイン
     * @property walletGst WalletのGSTコイン
     * @property walletSol WalletのSolanaコイン
     * @property walletUsdc WalletのUSDコイン
     * @property walletGem WalletのGem保持数
     * @property walletShoebox WalletのShoebox保持数
     * @property walletSneaker WalletのSneaker保持数
     * @property rateGmt GMTコインの日本円レート
     * @property rateGst GSTコインの日本円レート
     * @property rateSol Solanaコインの日本円レート
     * @property rateUsdc USDコインの日本円レート
     * @property rateGem GemのSolanaレート
     * @property rateShoebox ShoeboxのSolanaレート
     * @property rateSneaker WalletのSolanaレート
     */
    data class State(
        val spendingGmt: String = "0",
        val spendingGst: String = "0",
        val spendingSol: String = "0",
        val spendingGem: String = "0",
        val spendingShoebox: String = "0",
        val spendingSneaker: String = "0",
        val walletGmt: String = "0",
        val walletGst: String = "0",
        val walletSol: String = "0",
        val walletUsdc: String = "0",
        val walletGem: String = "0",
        val walletShoebox: String = "0",
        val walletSneaker: String = "0",
        val rateGmt: String = "0",
        val rateGst: String = "0",
        val rateSol: String = "0",
        val rateUsdc: String = "0",
        val rateGem: String = "0",
        val rateShoebox: String = "0",
        val rateSneaker: String = "0",
    ) : BaseContract.State

    /**
     * UIイベント
     *
     */
    sealed class Effect : BaseContract.Effect

    /**
     * アクション
     *
     */
    sealed class Event : BaseContract.Event {
        data class OnUpdateRateAssets(val type: AssetsType) : Event()
        data class OnUpdateWalletAssets(val type: AssetsType) : Event()
        data class OnUpdateSpendingAssets(val type: AssetsType) : Event()

        data class OnChangeRateGmt(val coin: String) : Event()
        data class OnChangeRateGst(val coin: String) : Event()
        data class OnChangeRateSol(val coin: String) : Event()
        data class OnChangeRateUsdc(val coin: String) : Event()
        data class OnChangeRateGem(val sol: String) : Event()
        data class OnChangeRateShoebox(val sol: String) : Event()
        data class OnChangeRateSneaker(val sol: String) : Event()
        data class OnChangeSpendingGmt(val coin: String) : Event()
        data class OnChangeSpendingGst(val coin: String) : Event()
        data class OnChangeSpendingSol(val coin: String) : Event()
        data class OnChangeSpendingGem(val count: String) : Event()
        data class OnChangeSpendingShoebox(val count: String) : Event()
        data class OnChangeSpendingSneaker(val count: String) : Event()
        data class OnChangeWalletGmt(val coin: String) : Event()
        data class OnChangeWalletGst(val coin: String) : Event()
        data class OnChangeWalletSol(val coin: String) : Event()
        data class OnChangeWalletUsdc(val coin: String) : Event()
        data class OnChangeWalletGem(val count: String) : Event()
        data class OnChangeWalletShoebox(val count: String) : Event()
        data class OnChangeWalletSneaker(val count: String) : Event()
    }
}