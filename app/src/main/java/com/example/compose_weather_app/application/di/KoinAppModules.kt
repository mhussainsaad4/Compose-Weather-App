package com.example.compose_weather_app.application.di

import com.example.compose_weather_app.main.di.mainModule
import com.example.compose_weather_app.home.di.homeModule
import org.koin.dsl.module

val parentModule = module {
    includes(mainModule, homeModule)
}

val koinAppModules = parentModule