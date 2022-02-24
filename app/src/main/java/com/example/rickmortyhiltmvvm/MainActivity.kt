package com.example.rickmortyhiltmvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmortyhiltmvvm.ViewModel.MainViewModel
import com.example.rickmortyhiltmvvm.adapter.AdapterCharacter
import com.example.rickmortyhiltmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mAdapter : AdapterCharacter
    //viewModel
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = AdapterCharacter()
        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        viewModel.responseImage.observe(this) { response ->
        if (response != null){
            mAdapter.submitList(response)
        }
    }

}

}