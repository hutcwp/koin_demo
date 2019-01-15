package com.hutcwp.demo.view.search

import com.hutcwp.demo.util.mvp.BasePresenter
import com.hutcwp.demo.util.mvp.BaseView

/**
 * Weather MVP Contract
 */
interface SearchContract {
    interface View : BaseView<Presenter> {
        fun displayNormal()
        fun displayProgress()
        fun onWeatherSuccess()
        fun onWeatherFailed(error: Throwable)
    }

    interface Presenter : BasePresenter<View> {
        fun getWeather(address: String)
    }
}