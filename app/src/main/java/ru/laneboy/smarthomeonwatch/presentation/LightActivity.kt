package ru.laneboy.smarthomeonwatch.presentation

import android.app.Activity
import android.os.Bundle
import ru.laneboy.smarthomeonwatch.databinding.ActivityLightBinding

class LightActivity : Activity() {

    private lateinit var binding: ActivityLightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLightBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}