package com.hutcwp.demo.di

import com.hutcwp.demo.repository.WeatherRepository
import com.hutcwp.demo.repository.WeatherRepositoryImpl
import com.hutcwp.demo.util.rx.ApplicationSchedulerProvider
import com.hutcwp.demo.util.rx.SchedulerProvider
import com.hutcwp.demo.view.detail.DetailContract
import com.hutcwp.demo.view.detail.DetailPresenter
import com.hutcwp.demo.view.result.ResultContract
import com.hutcwp.demo.view.result.ResultListContract
import com.hutcwp.demo.view.result.ResultListPresenter
import com.hutcwp.demo.view.result.ResultPresenter
import com.hutcwp.demo.view.search.SearchContract
import com.hutcwp.demo.view.search.SearchPresenter
import org.koin.dsl.module.module

val weatherModule = module {
    // Presenter for Search View
    factory { (view: SearchContract.View) ->
        SearchPresenter(get(), get(), view) as SearchContract.Presenter
    }

    // Weather Data Repository
    single {
        WeatherRepositoryImpl(get()) as WeatherRepository
    }

    single {
        ResultPresenter() as ResultContract.Presenter
    }

    factory { (view: ResultListContract.View) ->
        ResultListPresenter(get(), get(), get(), view) as ResultListContract.Presenter
    }

    factory { (view: DetailContract.View) ->
        DetailPresenter(get(), get(), view) as DetailContract.Presenter
    }
}

val rxModule = module {
    // provided components
    single { ApplicationSchedulerProvider() as SchedulerProvider }
}


// Gather all app modules
val weatherApp = listOf(weatherModule, rxModule)
