package ru.laneboy.smarthomeonwatch.presentation

import android.app.Activity
import android.os.Bundle
import ru.laneboy.smarthomeonwatch.databinding.ActivityDevicesBinding

class DevicesActivity : Activity() {

    private lateinit var binding: ActivityDevicesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDevicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}