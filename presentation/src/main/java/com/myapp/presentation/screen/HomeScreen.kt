package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.TotalChartContent
import com.myapp.model.value.*
import com.myapp.presentation.extension.chartColor
import com.myapp.presentation.viewmodel.HomeViewModel

/**
 * Home画面
 *
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeContent(viewModel)
}

@Composable
private fun HomeContent(viewModel: HomeViewModel) {
    val data = listOf(
        GstCoin(45000f),
        GmtCoin(23000f),
        SolanaCoin(12800f),
        UsdcCoin(134.849f)
    )

    val chartValues = data.map{ ChartValue(it.type().label, it.value.toString(), it.value, it.type().chartColor()) }
    Column {
        TotalChartContent(
            items = chartValues,
            titleLabel = "STEP'N COIN　合計値"
        )
    }
}