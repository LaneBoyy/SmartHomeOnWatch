package ru.laneboy.smarthomeonwatch

import android.app.Activity
import android.os.Bundle
import ru.laneboy.smarthomeonwatch.databinding.ActivityBoxesBinding

class BoxesActivity : Activity() {

    private lateinit var binding: ActivityBoxesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}