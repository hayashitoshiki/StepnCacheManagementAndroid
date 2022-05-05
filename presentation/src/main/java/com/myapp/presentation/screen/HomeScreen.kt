package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.TotalChartContent
import com.myapp.presentation.viewmodel.HomeContract
import com.myapp.presentation.viewmodel.HomeViewModel

/**
 * Home画面
 *
 */
@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state = viewModel.state.value
    HomeContent(state)
}

@Composable
private fun HomeContent(state: HomeContract.State) {
    Column {
        TotalChartContent(
            items = state.chartValue,
            titleLabel = "STEP'N COIN　合計値"
        )
    }
}