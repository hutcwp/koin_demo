package com.hutcwp.demo.view.detail

import com.hutcwp.demo.repository.WeatherRepository
import com.hutcwp.demo.util.ext.with
import com.hutcwp.demo.util.rx.SchedulerProvider
import com.hutcwp.demo.view.AbstractPresenter

class DetailPresenter(val weatherRepository: WeatherRepository, val schedulerProvider: SchedulerProvider, override var view : DetailContract.View) : AbstractPresenter<DetailContract.View, DetailContract.Presenter>(), DetailContract.Presenter {

    override fun getDetail(id: String) {
        launch {
            weatherRepository.getSelectedWeatherDetail(id).with(schedulerProvider).subscribe(
                    { detail ->
                        view.displayDetail(detail)
                    }, { err -> println("DetailPresenter error : $err") })
        }
    }
}