package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.DetailsChartContent
import com.myapp.presentation.extension.chartColor
import com.myapp.model.StepnCoin
import com.myapp.presentation.viewmodel.WalletTotalViewModel

/**
 * Wallet管理画面
 *
 */
@Composable
fun WalletTotalScreen(viewModel: WalletTotalViewModel) {
    WalletTotalContent(viewModel)
}

@Composable
private fun WalletTotalContent(viewModel: WalletTotalViewModel) {
    val data = listOf(
        StepnCoin.Gst(0f),
        StepnCoin.Gmt(257.5386f),
        StepnCoin.Solana(4.048f),
        StepnCoin.Usdc(1.849f)
    )

    val chartValues = data.map{ ChartValue(it.label, it.fullName, it.money, it.chartColor()) }
    Column {
        DetailsChartContent(
            items = chartValues,
            titleLabel = "Wallet　合計値"
        )
    }
}