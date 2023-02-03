package ru.laneboy.smarthomeonwatch.presentation.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.databinding.ActivityBoxesBinding
import ru.laneboy.smarthomeonwatch.domain.BoxItem
import ru.laneboy.smarthomeonwatch.presentation.BoxListAdapter

class BoxesActivity : Activity() {

    private lateinit var binding: ActivityBoxesBinding

    private var autoIncrementId = 0

    private lateinit var boxListAdapter: BoxListAdapter

    private val boxListLD = MutableLiveData<List<BoxItem>>()
    private val boxList = sortedSetOf<BoxItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBoxesList.layoutManager =GridLayoutManager(this, 2)
        setupRecyclerView()
        boxListAdapter.submitList(boxList.toMutableList())

    }

    private fun setupRecyclerView() {
        with(binding.rvBoxesList) {
            boxListAdapter = BoxListAdapter()
            adapter = boxListAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        boxListAdapter.onBoxItemClickListener = {
            val intent = Intent(this, DevicesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateList() {
        boxListLD.value = boxList.toList()
    }

    init {
        val itemLivingRoom = BoxItem("Living Room", R.drawable.ic_living_room)
        val itemLivingRoom1 = BoxItem("Living Room", R.drawable.ic_living_room)
        val itemKitchen = BoxItem("Kitchen", R.drawable.ic_kitchen)

        addBoxItem(itemKitchen)
        addBoxItem(itemLivingRoom)
        addBoxItem(itemLivingRoom1)
    }

    private fun addBoxItem(typeItem: BoxItem) {
        if (typeItem.id == BoxItem.UNDEFINED_ID) {
            typeItem.id = autoIncrementId++
        }
        boxList.add(typeItem)
        updateList()
    }
}