package com.example.weather_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.weather_app.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.searchBtn.setOnClickListener {
            val city = binding.cityInput.text.toString().trim()
            if (city.isNotEmpty()) {
                loadWeather(city)
            }
        }

        loadWeather("Moscow")
    }

    private fun loadWeather(city: String) {
        lifecycleScope.launch {
            try {
                val data = WeatherApi.retrofitService.getCurrentWeather(city)
                binding.weather = data
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}