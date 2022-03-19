package com.arpitparekh.kotlinafternoonbatch.retrofit_api_weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityWeatherBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherActivity : AppCompatActivity() {

    lateinit var binding : ActivityWeatherBinding
    lateinit var api : GetWeatherApi
    lateinit var list : ArrayList<Weather>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        binding.rvWeather.layoutManager = LinearLayoutManager(this)

        api = WeatherHelper.getInstance()

        binding.btnFindWather.setOnClickListener {

            list.clear()

            val location = binding.edtLocation.text.toString()

            val call =api.getWeather(location,"metric")

            call.enqueue(object : Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    val w = response.body()

                    list.add(w!!)

                   runOnUiThread {

                       val adapter = WeatherAdapter(list)

                       binding.rvWeather.adapter = adapter
                   }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("res",t.toString())
                }


            })



        }


    }
}