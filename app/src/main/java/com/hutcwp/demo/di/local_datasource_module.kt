package com.hutcwp.demo.di

import com.hutcwp.demo.model.WeatherDatasource
import com.hutcwp.demo.repository.local.AndroidJsonReader
import com.hutcwp.demo.repository.local.LocalDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module


val localAndroidDatasourceModule = module {
    single { AndroidJsonReader(androidApplication()) as com.hutcwp.demo.repository.local.JsonReader }
    single { LocalDataSource(get()) as WeatherDatasource }
}