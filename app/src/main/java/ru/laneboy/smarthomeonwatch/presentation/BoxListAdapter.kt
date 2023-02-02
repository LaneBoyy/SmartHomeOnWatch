package ru.laneboy.smarthomeonwatch.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.ListAdapter
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.domain.BoxItem

class BoxListAdapter : ListAdapter<BoxItem, BoxItemViewHolder>(BoxItemDiffCallback()) {

    var onBoxItemClickListener: ((BoxItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoxItemViewHolder {
        val layout = R.layout.box_item
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BoxItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoxItemViewHolder, position: Int) {
        val boxItem = getItem(position)
        with(holder) {
            tvBoxName.text = boxItem.name
            imBoxImage.setImageDrawable(boxItem.image.toDrawable())
            view.setOnClickListener {
                onBoxItemClickListener?.invoke(boxItem)
            }
        }
    }
}