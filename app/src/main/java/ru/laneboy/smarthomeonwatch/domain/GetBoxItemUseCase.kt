package ru.laneboy.smarthomeonwatch.domain

class GetBoxItemUseCase(private val boxListRepository: BoxListRepository) {

    fun getBoxItem(boxItemId: Int): BoxItem {
        return boxListRepository.getBoxItem(boxItemId)
    }
}