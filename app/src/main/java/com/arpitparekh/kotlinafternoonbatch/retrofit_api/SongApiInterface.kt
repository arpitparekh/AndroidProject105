package com.arpitparekh.kotlinafternoonbatch.retrofit_api

import com.arpitparekh.kotlinafternoonbatch.retrofit_api.kotlin_class.Song
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SongApiInterface {

    @GET("search")
    @Headers("x-rapidapi-host: genius.p.rapidapi.com",
        "x-rapidapi-key: 6bdba88936msh4cfcc257a36d9ebp12f3e9jsne224939e6077")
    fun getAllSongs(@Query("q")name : String) : Call<Song>

}