package ru.laneboy.smarthomeonwatch.domain

import androidx.annotation.DrawableRes

data class BoxItem(
    val name: String,
    @DrawableRes
    val image: Int,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}