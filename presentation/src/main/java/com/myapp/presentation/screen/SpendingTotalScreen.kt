package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.DetailsChartContent
import com.myapp.presentation.extension.chartColor
import com.myapp.model.StepnCoin
import com.myapp.presentation.viewmodel.SpendingTotalViewModel

/**
 * Spending管理画面
 *
 */
@Composable
fun SpendingTotalScreen(viewModel: SpendingTotalViewModel) {
    SpendingTotalContent(viewModel)
}

@Composable
private fun SpendingTotalContent(viewModel: SpendingTotalViewModel) {
    val data = listOf(
        StepnCoin.Gst(112.61f),
        StepnCoin.Gmt(107f),
        StepnCoin.Solana(0f)
    )

    val chartValues = data.map{ ChartValue(it.label, it.fullName, it.money, it.chartColor()) }
    Column {
        DetailsChartContent(
            items = chartValues,
            titleLabel = "Spending　合計値"
        )
    }
}