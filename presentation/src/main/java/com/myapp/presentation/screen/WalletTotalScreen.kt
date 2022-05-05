package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.myapp.component.component.DetailsChartContent
import com.myapp.presentation.viewmodel.WalletContract
import com.myapp.presentation.viewmodel.WalletTotalViewModel

/**
 * Wallet管理画面
 *
 */
@Composable
fun WalletTotalScreen(viewModel: WalletTotalViewModel) {
    val state = viewModel.state.value
    WalletTotalContent(state)
}

@Composable
private fun WalletTotalContent(state: WalletContract.State) {
    Column {
        DetailsChartContent(
            items = state.chartValue,
            titleLabel = "Wallet　合計値"
        )
    }
}