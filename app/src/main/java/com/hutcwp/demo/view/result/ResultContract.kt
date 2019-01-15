package com.hutcwp.demo.view.result

import com.hutcwp.demo.util.mvp.BasePresenter
import com.hutcwp.demo.util.mvp.BaseView
import com.hutcwp.demo.model.DailyForecastModel

/**
 * Weather MVP Contract
 */
interface ResultContract {
    interface View : BaseView<Presenter> {
        fun onDetailSaved(id : String)
        fun displayError(error: Throwable)
    }

    interface Presenter : BasePresenter<View> {
        fun selectWeatherDetail(detail: DailyForecastModel)
    }
}
