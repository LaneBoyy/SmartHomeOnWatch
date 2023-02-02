package ru.laneboy.smarthomeonwatch.domain

import androidx.lifecycle.LiveData

interface BoxListRepository {

    fun addBoxItem(boxItem: BoxItem)

    fun getBoxItem(boxItemId: Int): BoxItem

    fun getBoxList(): LiveData<List<BoxItem>>
}