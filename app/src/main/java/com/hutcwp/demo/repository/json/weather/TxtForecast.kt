package com.hutcwp.demo.repository.json.weather

import com.google.gson.annotations.Expose
import com.hutcwp.demo.repository.json.weather.Forecastday

import java.util.ArrayList

class TxtForecast {

    /**
     * @return The date
     */
    /**
     * @param date The date
     */
    @Expose
    var date: String? = null
    /**
     * @return The forecastday
     */
    /**
     * @param forecastday The forecastday
     */
    @Expose
    var forecastday: List<Forecastday> = ArrayList()

}
