package com.hutcwp.demo.view.detail

import com.hutcwp.demo.util.mvp.BasePresenter
import com.hutcwp.demo.util.mvp.BaseView
import com.hutcwp.demo.model.DailyForecastModel

interface DetailContract {
    interface View : BaseView<Presenter> {
        fun displayDetail(weather: DailyForecastModel)
    }

    interface Presenter : BasePresenter<View> {
        fun getDetail(id : String)
    }
}