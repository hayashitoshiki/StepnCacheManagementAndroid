package com.myapp.model.value

/**
 * STEP'Nのコインの種別定義
 *
 * @property label 表示用ラベル(短縮名)
 * @property fullName 表示用ラベル(フルネーム)
 */
enum class StepnCoinType(val label: String, val fullName: String) {
    GMT("GMT", "STEPN"),
    GST("GST", "Green Satoshi Token"),
    SOL("SOL", "Solana"),
    USCD("USDC", "USD Coin")
}