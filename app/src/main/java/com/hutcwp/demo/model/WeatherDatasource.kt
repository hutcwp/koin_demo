package com.hutcwp.demo.model

import com.hutcwp.demo.repository.json.geocode.Geocode
import com.hutcwp.demo.repository.json.weather.Weather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Weather datasource - Retrofit tagged
 */
interface WeatherDatasource {

    @GET("/geocode")
    @Headers("Content-type: application/json")
    fun geocode(@Query("address") address: String): Single<Geocode>

    @GET("/weather")
    @Headers("Content-type: application/json")
    fun weather(@Query("lat") lat: Double?, @Query("lon") lon: Double?, @Query("lang") lang: String): Single<Weather>

}
