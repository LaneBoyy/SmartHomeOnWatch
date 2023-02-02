package ru.laneboy.smarthomeonwatch.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.domain.BoxItem
import ru.laneboy.smarthomeonwatch.domain.BoxListRepository

object BoxListRepositoryImpl : BoxListRepository {

    private val boxListLD = MutableLiveData<List<BoxItem>>()
    private val boxList = sortedSetOf<BoxItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId = 0

    init {
        for (i in 0 until 4) {
            val item = BoxItem("Living Room", R.drawable.ic_logo)
            addBoxItem(item)
        }
    }

    override fun addBoxItem(boxItem: BoxItem) {
        if (boxItem.id == BoxItem.UNDEFINED_ID) {
            boxItem.id = autoIncrementId++
        }
        boxList.add(boxItem)
        updateList()
    }

    override fun getBoxItem(boxItemId: Int): BoxItem {
        return boxList.find {
            it.id ==boxItemId
        } ?: throw RuntimeException("Element with id $boxItemId not found")
    }

    override fun getBoxList(): LiveData<List<BoxItem>> {
        return boxListLD
    }

    private fun updateList() {
        boxListLD.value = boxList.toList()
    }
}