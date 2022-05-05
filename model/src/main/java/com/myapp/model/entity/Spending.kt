package com.myapp.model.entity

import com.myapp.model.value.GmtCoin
import com.myapp.model.value.GstCoin
import com.myapp.model.value.SolanaCoin

/**
 * Spending
 *
 * @property gst GSTコイン
 * @property gmt GMTコイン
 * @property sol Solanaコイン
 */
data class Spending(
    var gst: GstCoin,
    var gmt: GmtCoin,
    var sol: SolanaCoin
) {
    fun values() = listOf(gst, gmt, sol)
}