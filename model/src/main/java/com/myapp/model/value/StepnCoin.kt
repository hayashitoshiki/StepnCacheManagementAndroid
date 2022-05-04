package com.myapp.model

/**
 * STEP'Nのコインオブジェクト定義
 *
 */
sealed class StepnCoin {
    /**
     * 価格
     */
    abstract val money: Float
    /**
     * 表示用ラベル
     */
    abstract val label: String
    /**
     * 表示用ラベル
     */
    abstract val fullName: String

    data class Gmt(override val money: Float) : StepnCoin() {
        override val label = "GMT"
        override val fullName = "STEPN"
    }
    data class Gst(override val money: Float) : StepnCoin() {
        override val label = "GST"
        override val fullName = "Green Satoshi Token"
    }
    data class Solana(override val money: Float) : StepnCoin() {
        override val label = "SOL"
        override val fullName = "Solana"
    }
    data class Usdc(override val money: Float) : StepnCoin() {
        override val label = "USDC"
        override val fullName = "USD Coin"

    }
}