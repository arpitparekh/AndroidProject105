package com.arpitparekh.kotlinafternoonbatch.retrofit_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityDataListBinding
import com.arpitparekh.kotlinafternoonbatch.retrofit_api.kotlin_class.ApiHelper
import com.arpitparekh.kotlinafternoonbatch.retrofit_api.kotlin_class.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataListActivity : AppCompatActivity() {

    lateinit var binding : ActivityDataListBinding
    lateinit var api : SongApiInterface
    lateinit var list : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // https://rapidapi.com/brianiswu/api/genius/

        list = ArrayList()


        api = ApiHelper.getInstance()

        binding.btnSongs.setOnClickListener {

            var artist = binding.edtArtist.text.toString()

            artist = artist.replace(" ","%20")

            val call =  api.getAllSongs(artist)

            call.enqueue(object : Callback<Song>{
                override fun onResponse(call: Call<Song>, response: Response<Song>) {

                    list.clear()

                    val song = response.body()

                    val listNew = song?.response?.hits

                    if (listNew != null) {

                        for(obj in listNew){

                           val data : String =  obj?.result?.fullTitle+"\n"+obj?.result?.id

                            list.add(data)


                        }

                        val adapter = ArrayAdapter<String>(this@DataListActivity,android.R.layout.simple_list_item_1,list)

                        binding.listViewSongs.adapter = adapter
                    }


                }

                override fun onFailure(call: Call<Song>, t: Throwable) {
                    Log.i("error",t.toString())
                }


            })



        }


    }
}