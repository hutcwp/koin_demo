package com.hutcwp.demo.view.result

import com.hutcwp.demo.util.mvp.BasePresenter
import com.hutcwp.demo.util.mvp.BaseView
import com.hutcwp.demo.model.DailyForecastModel

interface ResultListContract {
    interface View : BaseView<Presenter> {
        fun displayWeather(weatherList: List<DailyForecastModel>)
        fun displayError(error: Throwable)
    }

    interface Presenter : BasePresenter<View> {
        fun getWeather()
        fun selectWeatherDetail(detail: DailyForecastModel)
    }
}