package com.example.compose_weather_app.home.di

import com.example.compose_weather_app.home.interfaces.IHomeRepository
import com.example.compose_weather_app.home.repository.HomeRepositoryImp
import com.example.compose_weather_app.home.viewModel.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    // Your definitions ...
    viewModel { HomeViewModel(androidApplication()) }
    single<IHomeRepository> { HomeRepositoryImp() }
}