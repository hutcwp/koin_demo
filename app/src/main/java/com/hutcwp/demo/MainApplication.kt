package com.hutcwp.demo

import android.app.Application
import com.hutcwp.demo.di.localAndroidDatasourceModule
import com.hutcwp.demo.di.weatherApp
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.WeathericonsModule
import org.koin.android.ext.android.startKoin

/**
 * Main Application
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin(this, weatherApp + localAndroidDatasourceModule)

        Iconify.with(WeathericonsModule())
    }
}
