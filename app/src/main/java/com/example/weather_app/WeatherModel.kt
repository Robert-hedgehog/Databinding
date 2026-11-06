package com.example.weather_app

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<WeatherDescription>
)

data class Main(
    val temp: Double
)

data class WeatherDescription(
    val description: String
)