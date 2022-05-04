package com.myapp.presentation.extension

import androidx.compose.ui.graphics.Color
import com.myapp.component.theme.gmtColor
import com.myapp.component.theme.gstColor
import com.myapp.component.theme.solanaColor
import com.myapp.component.theme.usdcColor
import com.myapp.model.value.StepnCoin
import com.myapp.model.value.StepnCoinType


/**
 * StepnCoinTypeの色定義
 *
 * @return 各Labelに対するグラフ色
 */
fun StepnCoinType.chartColor() : Color {
    return when(this) {
        StepnCoinType.GMT -> gmtColor
        StepnCoinType.GST -> gstColor
        StepnCoinType.SOL -> solanaColor
        StepnCoinType.USCD -> usdcColor
    }
}