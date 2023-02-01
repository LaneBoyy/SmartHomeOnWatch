package ru.laneboy.smarthomeonwatch

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.laneboy.smarthomeonwatch.domain.BoxItem

class BoxItemDiffCallback: DiffUtil.ItemCallback<BoxItem>() {

    override fun areItemsTheSame(oldItem: BoxItem, newItem: BoxItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BoxItem, newItem: BoxItem): Boolean {
        return oldItem == newItem
    }
}