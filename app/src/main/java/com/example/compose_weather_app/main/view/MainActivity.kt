package com.example.compose_weather_app.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose_weather_app.extensions.ActivityBaseTheme
import com.example.compose_weather_app.home.view.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityBaseTheme {
                Home()
            }
        }
    }
}