package com.myapp.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.myapp.model.value.StepnCoinType
import com.myapp.presentation.viewmodel.SettingContract
import com.myapp.presentation.viewmodel.SettingViewModel

/**
 * Home画面
 *
 */
@Composable
fun SettingScreen(viewModel: SettingViewModel) {
    val state = viewModel.state.value
    val action: (SettingContract.Event) -> Unit = { viewModel.setEvent(it) }
    SettingContent(state, action)
}

@Composable
private fun SettingContent(
    state: SettingContract.State,
    action: (SettingContract.Event) -> Unit
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(text = "Spending")
        UpdateInputArea(
            label = StepnCoinType.GMT.label,
            value = state.spendingGmt,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingCoin(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.spendingGst,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingCoin(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.spendingSol,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingCoin(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingSol(it)) }
        )
        Text(text = "Wallet")
        UpdateInputArea(
            label = StepnCoinType.GMT.label,
            value = state.walletGmt,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletCoin(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.walletGst,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletCoin(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.walletSol,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletCoin(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletSol(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.USCD.label,
            value = state.walletUsdc,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletCoin(StepnCoinType.USCD)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletUsdc(it)) }
        )
        Text(text = "相場")
        UpdateInputArea(
            label = StepnCoinType.GMT.label,
            value = state.rateGmt,
            onClickAction = { action(SettingContract.Event.OnUpdateRateCoin(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.rateGst,
            onClickAction = { action(SettingContract.Event.OnUpdateRateCoin(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.rateSol,
            onClickAction = { action(SettingContract.Event.OnUpdateRateCoin(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateSol(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.USCD.label,
            value = state.rateUsdc,
            onClickAction = { action(SettingContract.Event.OnUpdateRateCoin(StepnCoinType.USCD)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateUsdc(it)) }
        )
    }
}

@Composable
fun UpdateInputArea(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onTextChange: (String) -> Unit,
    onClickAction: () -> Unit
) {
    Row(modifier = modifier) {
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = value,
            onValueChange = { onTextChange(it) },
            label = { Text(label) },
        )
        Button(onClick = { onClickAction() }) {
            Text(text = "変更")
        }
    }
}
