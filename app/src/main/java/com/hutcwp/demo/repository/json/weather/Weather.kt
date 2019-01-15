package com.hutcwp.demo.repository.json.weather

import com.google.gson.annotations.Expose
import com.hutcwp.demo.repository.json.weather.Forecast
import com.hutcwp.demo.repository.json.weather.Response

class Weather {

    /**
     * @return The response
     */
    /**
     * @param response The response
     */
    @Expose
    var response: Response? = null
    /**
     * @return The forecast
     */
    /**
     * @param forecast The forecast
     */
    @Expose
    var forecast: Forecast? = null

}
