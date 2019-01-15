package com.hutcwp.demo.repository.local

import com.hutcwp.demo.repository.json.geocode.Geocode
import com.hutcwp.demo.repository.json.weather.Weather
import com.hutcwp.demo.repository.json.geocode.Location

/**
 * Json reader
 */
interface JsonReader {
    fun getAllLocations(): Map<Location, String>
    fun getWeather(name: String): Weather
    fun getGeocode(name: String): Geocode
}