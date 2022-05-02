package com.myapp.presentation.extension

import androidx.compose.ui.graphics.Color
import com.myapp.component.theme.gmtColor
import com.myapp.component.theme.gstColor
import com.myapp.component.theme.solanaColor
import com.myapp.component.theme.usdcColor
import com.myapp.model.StepnCoin


/**
 * StepnCoinの色定義
 *
 * @return 各Labelに対するグラフ色
 */
fun StepnCoin.chartColor() : Color {
    return when(this) {
        is StepnCoin.Gmt -> gmtColor
        is StepnCoin.Gst -> gstColor
        is StepnCoin.Solana -> solanaColor
        is StepnCoin.Usdc -> usdcColor
    }
}