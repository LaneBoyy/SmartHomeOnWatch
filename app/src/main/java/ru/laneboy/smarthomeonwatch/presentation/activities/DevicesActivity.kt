package ru.laneboy.smarthomeonwatch.presentation.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.databinding.ActivityDevicesBinding
import ru.laneboy.smarthomeonwatch.domain.BoxItem
import ru.laneboy.smarthomeonwatch.presentation.BoxListAdapter

class DevicesActivity : Activity() {

    private lateinit var binding: ActivityDevicesBinding

    private var autoIncrementId = 0

    private lateinit var devicesListAdapter: BoxListAdapter

    private val devicesListLD = MutableLiveData<List<BoxItem>>()
    private val devicesList = sortedSetOf<BoxItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDevicesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvDevicesList.layoutManager = GridLayoutManager(this, 2)
        setupRecyclerView()
        devicesListAdapter.submitList(devicesList.toMutableList())

    }

    private fun setupRecyclerView() {
        with(binding.rvDevicesList) {
            devicesListAdapter = BoxListAdapter()
            adapter = devicesListAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        devicesListAdapter.onBoxItemClickListener = {
            val intent = Intent(this, LightActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateList() {
        devicesListLD.value = devicesList.toList()
    }

    init {
        val itemLivingRoom = BoxItem("Light", R.drawable.ic_round_lightbulb_24)
        val itemLivingRoom1 = BoxItem("Light", R.drawable.ic_round_lightbulb_24)
        val itemKitchen = BoxItem("Thermostat", R.drawable.ic_round_thermostat_24)

        addBoxItem(itemKitchen)
        addBoxItem(itemLivingRoom)
        addBoxItem(itemLivingRoom1)
    }

    private fun addBoxItem(typeItem: BoxItem) {
        if (typeItem.id == BoxItem.UNDEFINED_ID) {
            typeItem.id = autoIncrementId++
        }
        devicesList.add(typeItem)
        updateList()
    }
}