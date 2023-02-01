package ru.laneboy.smarthomeonwatch.presentation.activities

import android.app.Activity
import android.content.Intent
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