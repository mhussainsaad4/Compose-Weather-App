package com.example.compose_weather_app.application

import android.app.Application
import com.example.compose_weather_app.application.di.koinAppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            allowOverride(true)
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@WeatherApplication)
            // Load modules
            modules(koinAppModules)
        }
    }
}