package com.hutcwp.demo.view.result

import com.hutcwp.demo.view.AbstractPresenter
import com.hutcwp.demo.model.DailyForecastModel

/**
 * Weather Presenter
 */
class ResultPresenter() : AbstractPresenter<ResultContract.View, ResultContract.Presenter>(), ResultContract.Presenter {
    override fun selectWeatherDetail(detail: DailyForecastModel) {
        view.onDetailSaved(detail.id)
    }
}