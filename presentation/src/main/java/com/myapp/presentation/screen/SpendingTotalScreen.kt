package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.ChartValue
import com.myapp.component.component.DetailsChartContent
import com.myapp.model.value.GmtCoin
import com.myapp.model.value.GstCoin
import com.myapp.model.value.SolanaCoin
import com.myapp.presentation.extension.chartColor
import com.myapp.model.value.StepnCoin
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
        GstCoin(112.61f),
        GmtCoin(107f),
        SolanaCoin(0f)
    )

    val chartValues = data.map{ ChartValue(it.type().label, it.value.toString(), it.value, it.type().chartColor()) }
    Column {
        DetailsChartContent(
            items = chartValues,
            titleLabel = "Spending　合計値"
        )
    }
}