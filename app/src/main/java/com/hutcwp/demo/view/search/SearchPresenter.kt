package com.hutcwp.demo.view.search

import com.hutcwp.demo.repository.WeatherRepository
import com.hutcwp.demo.util.ext.with
import com.hutcwp.demo.util.rx.SchedulerProvider
import com.hutcwp.demo.view.AbstractPresenter

class SearchPresenter(val weatherRepository: WeatherRepository, val schedulerProvider: SchedulerProvider, override var view: SearchContract.View) : AbstractPresenter<SearchContract.View, SearchContract.Presenter>(),
    SearchContract.Presenter {

    override fun getWeather(address: String) {
        view.displayProgress()
        launch {
            weatherRepository.searchWeather(address)
                    .with(schedulerProvider)
                    .subscribe({
                        view.displayNormal()
                        view.onWeatherSuccess()
                    }, { error ->
                        view.displayNormal()
                        view.onWeatherFailed(error)
                    })
        }
    }
}