package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.DetailsChartContent
import com.myapp.model.value.*
import com.myapp.presentation.extension.chartColor
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
        GstCoin(0f),
        GmtCoin(257.5386f),
        SolanaCoin(1230f),
        UsdcCoin(134.849f)
    )
    val chartValues = data.map{ ChartValue(it.type().label, it.value.toString(), it.value, it.type().chartColor()) }
    Column {
        DetailsChartContent(
            items = chartValues,
            titleLabel = "Wallet　合計値"
        )
    }
}