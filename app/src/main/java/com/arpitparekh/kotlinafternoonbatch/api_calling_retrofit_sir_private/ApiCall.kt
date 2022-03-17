package com.arpitparekh.kotlinafternoonbatch.api_calling_retrofit_sir_private

import retrofit2.Call
import retrofit2.http.*

interface ApiCall {

    @GET("notes")
    fun getAllNotes() : Call<List<Note>>

    @GET("notes/{id}")
    fun getSpecificNotes(@Path("id")id : Int) : Call<Note>

    @POST("notes/create/")
    @FormUrlEncoded
    fun createNote(@Field("body") body : String) : Call<Note>

    @DELETE("notes/{id}/delete/")
    fun deleteNote(@Path("id") id : Int) : Call<Note>

    @PUT("notes/{id}/update/")
    @FormUrlEncoded
    fun updateNote(@Path("id") id : Int,@Field("body") body : String) : Call<Note>

}