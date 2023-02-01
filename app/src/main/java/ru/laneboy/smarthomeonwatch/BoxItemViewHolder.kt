package ru.laneboy.smarthomeonwatch

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BoxItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvBoxName = view.findViewById<TextView>(R.id.tv_box_name)
    val imBoxImage = view.findViewById<ImageView>(R.id.iv_box_image)
}