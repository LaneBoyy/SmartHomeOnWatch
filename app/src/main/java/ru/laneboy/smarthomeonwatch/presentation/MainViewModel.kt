package ru.laneboy.smarthomeonwatch.presentation

import androidx.lifecycle.ViewModel
import ru.laneboy.smarthomeonwatch.data.BoxListRepositoryImpl
import ru.laneboy.smarthomeonwatch.domain.GetBoxListUseCase

class MainViewModel : ViewModel() {

    private val repository = BoxListRepositoryImpl

    private val getBoxListUseCase = GetBoxListUseCase(repository)

    val boxList = getBoxListUseCase.getBoxList()
}