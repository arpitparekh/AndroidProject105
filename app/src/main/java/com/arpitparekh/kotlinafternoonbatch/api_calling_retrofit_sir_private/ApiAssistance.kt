package com.arpitparekh.kotlinafternoonbatch.api_calling_retrofit_sir_private

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAssistance {

    companion object{

        fun getInstance() : ApiCall{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://mauliktesting.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiCall :: class.java)
        }

    }

}