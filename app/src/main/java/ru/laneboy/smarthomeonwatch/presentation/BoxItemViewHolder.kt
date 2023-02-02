package ru.laneboy.smarthomeonwatch.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.smarthomeonwatch.R

class BoxItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvBoxName = view.findViewById<TextView>(R.id.tv_box_name)
    val imBoxImage = view.findViewById<ImageView>(R.id.iv_box_image)
}