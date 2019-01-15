package com.hutcwp.demo.repository.local

import com.hutcwp.demo.model.WeatherDatasource
import com.hutcwp.demo.repository.json.geocode.Geocode
import com.hutcwp.demo.repository.json.weather.Weather
import io.reactivex.Single
import com.hutcwp.demo.repository.json.geocode.Location

/**
 * Read json files and render weather data
 */
class LocalDataSource(val jsonReader: JsonReader) : WeatherDatasource {
    private val cities = HashMap<Location, String>()

    init {
        cities += jsonReader.getAllLocations()
    }

    private fun isKnownCity(address: String): Boolean = cities.values.contains(address)

    private fun cityFromLocation(lat: Double?, lng: Double?): String {
        return cities.filterKeys { it.lat == lat && it.lng == lng }.values.firstOrNull()
                ?: DEFAULT_CITY
    }

    override fun geocode(address: String): Single<Geocode> {
        return Single.create { s ->
            val addressToLC = address.toLowerCase()
            val geocode = if (isKnownCity(addressToLC)) {
                jsonReader.getGeocode(addressToLC)
            } else {
                jsonReader.getGeocode(DEFAULT_CITY)
            }
            s.onSuccess(geocode)
        }
    }

    override fun weather(lat: Double?, lon: Double?, lang: String): Single<Weather> {
        return Single.create { s ->
            val city = cityFromLocation(lat, lon)
            val weather = jsonReader.getWeather(city)
            s.onSuccess(weather)
        }
    }

    companion object {
        const val DEFAULT_CITY = "toulouse"
    }
}