package ru.laneboy.smarthomeonwatch.presentation.activities

import android.app.Activity
import android.os.Bundle
import ru.laneboy.smarthomeonwatch.databinding.ActivityLightBinding

class LightActivity : Activity() {

    private lateinit var binding: ActivityLightBinding
    private var gr = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCountOfLight.text = gr.toString()


        onBtnPlusClick()
        onBtnMinusClick()
    }

    private fun onBtnPlusClick() {
        binding.btnPlus.setOnClickListener {
            val degrees = binding.tvCountOfLight.text.toString()
            var degreesInt = degrees.toInt()
            if (degreesInt != 100) {
                degreesInt++
                binding.tvCountOfLight.text = degreesInt.toString()
            }
        }
    }

    private fun onBtnMinusClick() {
        binding.btnMinus.setOnClickListener {
            val degrees = binding.tvCountOfLight.text.toString()
            var degreesInt = degrees.toInt()
            if (degreesInt != 0) {
                degreesInt--
                binding.tvCountOfLight.text = degreesInt.toString()
            }
        }
    }
}