package com.arpitparekh.kotlinafternoonbatch.retrofit_api_weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherHelper {

    companion object{

        fun getInstance() : GetWeatherApi{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://community-open-weather-map.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val getWeatherApi : GetWeatherApi = retrofit.create(GetWeatherApi ::class.java)

            return getWeatherApi

        }

    }
}