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
import com.myapp.model.value.RealAssetsType
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
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.spendingGst,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.spendingSol,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingSol(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.GEM.label,
            value = state.spendingGem,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(RealAssetsType.GEM)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingGem(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SHOEBOX.label,
            value = state.spendingShoebox,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(RealAssetsType.SHOEBOX)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingShoebox(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SNEAKER.label,
            value = state.spendingSneaker,
            onClickAction = { action(SettingContract.Event.OnUpdateSpendingAssets(RealAssetsType.SNEAKER)) },
            onTextChange = { action(SettingContract.Event.OnChangeSpendingSneaker(it)) }
        )

        Text(text = "Wallet")
        UpdateInputArea(
            label = StepnCoinType.GMT.label,
            value = state.walletGmt,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.walletGst,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.walletSol,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletSol(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.USCD.label,
            value = state.walletUsdc,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(StepnCoinType.USCD)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletUsdc(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.GEM.label,
            value = state.walletGem,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(RealAssetsType.GEM)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletGem(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SHOEBOX.label,
            value = state.walletShoebox,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(RealAssetsType.SHOEBOX)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletShoebox(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SNEAKER.label,
            value = state.walletSneaker,
            onClickAction = { action(SettingContract.Event.OnUpdateWalletAssets(RealAssetsType.SNEAKER)) },
            onTextChange = { action(SettingContract.Event.OnChangeWalletSneaker(it)) }
        )

        Text(text = "相場")
        UpdateInputArea(
            label = StepnCoinType.GMT.label,
            value = state.rateGmt,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(StepnCoinType.GMT)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateGmt(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.GST.label,
            value = state.rateGst,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(StepnCoinType.GST)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateGst(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.SOL.label,
            value = state.rateSol,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(StepnCoinType.SOL)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateSol(it)) }
        )
        UpdateInputArea(
            label = StepnCoinType.USCD.label,
            value = state.rateUsdc,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(StepnCoinType.USCD)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateUsdc(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.GEM.label,
            value = state.rateGem,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(RealAssetsType.GEM)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateGem(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SHOEBOX.label,
            value = state.rateShoebox,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(RealAssetsType.SHOEBOX)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateShoebox(it)) }
        )
        UpdateInputArea(
            label = RealAssetsType.SNEAKER.label,
            value = state.rateSneaker,
            onClickAction = { action(SettingContract.Event.OnUpdateRateAssets(RealAssetsType.SNEAKER)) },
            onTextChange = { action(SettingContract.Event.OnChangeRateSneaker(it)) }
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
