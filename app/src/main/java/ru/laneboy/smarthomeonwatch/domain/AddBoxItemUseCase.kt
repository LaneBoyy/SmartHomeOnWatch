package ru.laneboy.smarthomeonwatch.domain

class AddBoxItemUseCase(private val boxListRepository: BoxListRepository) {

    fun addBoxItem(boxItem: BoxItem) {
        boxListRepository.addBoxItem(boxItem)
    }
}