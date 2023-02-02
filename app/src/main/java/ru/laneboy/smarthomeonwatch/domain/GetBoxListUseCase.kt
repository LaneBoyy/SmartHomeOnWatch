package ru.laneboy.smarthomeonwatch.domain

import androidx.lifecycle.LiveData

class GetBoxListUseCase(private val boxListRepository: BoxListRepository) {

    fun getBoxList(): LiveData<List<BoxItem>> {
        return boxListRepository.getBoxList()
    }
}