package com.hutcwp.demo.view.result

import com.hutcwp.demo.repository.WeatherRepository
import com.hutcwp.demo.util.ext.with
import com.hutcwp.demo.util.rx.SchedulerProvider
import com.hutcwp.demo.view.AbstractPresenter
import com.hutcwp.demo.model.DailyForecastModel

/**
 * Weather Presenter
 */
class ResultListPresenter(
    val weatherRepository: WeatherRepository,
    val schedulerProvider: SchedulerProvider,
    val weatherResultPresenter: ResultContract.Presenter,
    override var view: ResultListContract.View
) : AbstractPresenter<ResultListContract.View, ResultListContract.Presenter>(), ResultListContract.Presenter {

    override fun getWeather() {
        launch {
            weatherRepository.getWeather()
                .with(schedulerProvider)
                .subscribe(
                    { weatherList -> view.displayWeather(weatherList) },
                    { error -> view.displayError(error) })
        }
    }

    override fun selectWeatherDetail(detail: DailyForecastModel) {
        launch {
            weatherRepository.getSelectedWeatherDetail(detail.id)
                .with(schedulerProvider)
                .subscribe({
                    weatherResultPresenter.selectWeatherDetail(detail)
                }, { err ->
                    view.displayError(err)
                })
        }
    }
}