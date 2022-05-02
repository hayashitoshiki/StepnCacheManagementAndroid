package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.TotalChartContent
import com.myapp.presentation.extension.chartColor
import com.myapp.model.StepnCoin
import com.myapp.presentation.viewmodel.HomeViewModel

/**
 * Home画面
 *
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    SpendingTotalContent(viewModel)
}

@Composable
private fun SpendingTotalContent(viewModel: HomeViewModel) {
    val data = listOf(
        StepnCoin.Gst(10000f),
        StepnCoin.Gmt(501f),
        StepnCoin.Solana(12800f),
        StepnCoin.Usdc(1.849f)
    )

    val chartValues = data.map{ ChartValue(it.label, it.money.toString(), it.money, it.chartColor()) }
    Column {
        TotalChartContent(
            items = chartValues,
            titleLabel = "STEP'N COIN　合計値"
        )
    }
}