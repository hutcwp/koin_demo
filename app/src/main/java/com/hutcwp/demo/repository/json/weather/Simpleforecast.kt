package com.hutcwp.demo.repository.json.weather

import com.google.gson.annotations.Expose
import com.hutcwp.demo.repository.json.weather.Forecastday_

import java.util.ArrayList

class Simpleforecast {

    /**
     * @return The forecastday
     */
    /**
     * @param forecastday The forecastday
     */
    @Expose
    var forecastday: List<Forecastday_> = ArrayList()

}
