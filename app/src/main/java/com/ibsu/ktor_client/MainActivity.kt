package com.ibsu.ktor_client

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.ibsu.ktor_client.databinding.ActivityMainBinding
import com.ibsu.ktor_client.ui.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.getLocation()
        }

        // Observe changes in locationLiveData
        viewModel.locationLiveData.observe(this, Observer { location ->
            //Observer's onChanged method (this lambda callback) is executed on the main (UI) thread automatically,
            // This block of code is executed when the data in locationLiveData changes

            // The 'location' parameter contains the updated data
            // Update UI when locationLiveData changes
            if(location!=null)
                binding.textView.text = location.city
        })
    }
}