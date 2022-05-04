package com.myapp.model.value

/**
 * STEP' コインの既定クラス
 *
 */
sealed class StepnCoin {
    abstract val value: Float
    abstract fun type() : StepnCoinType
}


data class GmtCoin(override val value: Float) : StepnCoin() {
    override fun type() = StepnCoinType.GMT
}

data class GstCoin(override val value: Float) : StepnCoin() {
    override fun type() = StepnCoinType.GST
}

data class SolanaCoin(override val value: Float) : StepnCoin() {
    override fun type() = StepnCoinType.SOL
}

data class UsdcCoin(override val value: Float) : StepnCoin() {
    override fun type() = StepnCoinType.USCD
}