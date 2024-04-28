package com.example.compose_weather_app.main.di

import com.example.compose_weather_app.main.interfaces.IMainRepository
import com.example.compose_weather_app.main.repository.MainRepositoryImp
import com.example.compose_weather_app.main.viewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    // Your definitions ...
    viewModel { MainViewModel(androidApplication()) }
    single<IMainRepository> { MainRepositoryImp() }
}