package com.hutcwp.demo.view.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hutcwp.demo.R
import com.hutcwp.demo.util.ext.argument
import com.hutcwp.demo.view.Arguments.ARG_ADDRESS
import com.hutcwp.demo.view.Arguments.ARG_WEATHER_DATE
import com.hutcwp.demo.view.Arguments.ARG_WEATHER_ITEM_ID
import kotlinx.android.synthetic.main.activity_weather_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import com.hutcwp.demo.model.DailyForecastModel
import java.util.*

/**
 * Weather Detail View
 */
class DetailActivity : AppCompatActivity(), DetailContract.View {

    // Get all needed data
    private val address by argument<String>(ARG_ADDRESS)
    private val now by argument<Date>(ARG_WEATHER_DATE)
    private val detailId by argument<String>(ARG_WEATHER_ITEM_ID)

    override val presenter: DetailContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)
    }

    override fun onStart() {
        super.onStart()
        presenter.getDetail(detailId)
    }

    override fun onDestroy() {
        presenter.stop()
        super.onDestroy()
    }

    override fun displayDetail(weather: DailyForecastModel) {
        weatherTitle.text = getString(R.string.weather_title).format(address, now)
        weatherItemIcon.text = weather.icon
        weatherItemForecast.text = weather.forecastString
        weatherItemTemp.text = weather.temperatureString
    }
}
