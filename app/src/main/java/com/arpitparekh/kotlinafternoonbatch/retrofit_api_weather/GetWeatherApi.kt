package com.arpitparekh.kotlinafternoonbatch.retrofit_api_weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GetWeatherApi {

    @GET("weather")
    @Headers("x-rapidapi-host: community-open-weather-map.p.rapidapi.com"
        ,"x-rapidapi-key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077")
    fun getWeather(@Query("q")location : String,@Query("units")unit : String) : Call<Weather>

}