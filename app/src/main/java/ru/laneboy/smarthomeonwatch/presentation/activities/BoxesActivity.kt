package ru.laneboy.smarthomeonwatch.presentation.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.smarthomeonwatch.R
import ru.laneboy.smarthomeonwatch.databinding.ActivityBoxesBinding
import ru.laneboy.smarthomeonwatch.presentation.BoxListAdapter
import ru.laneboy.smarthomeonwatch.presentation.MainViewModel

class BoxesActivity : Activity() {

    private lateinit var binding: ActivityBoxesBinding

    private lateinit var boxListAdapter: BoxListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBoxesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

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
}