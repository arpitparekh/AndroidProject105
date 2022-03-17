package com.arpitparekh.kotlinafternoonbatch.retrofit_api.kotlin_class

import com.arpitparekh.kotlinafternoonbatch.retrofit_api.SongApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {

    companion object{

        fun getInstance() : SongApiInterface{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://genius.p.rapidapi.com/")
                .build()

            val api : SongApiInterface = retrofit.create(SongApiInterface::class.java)

            return api

        }


    }

}