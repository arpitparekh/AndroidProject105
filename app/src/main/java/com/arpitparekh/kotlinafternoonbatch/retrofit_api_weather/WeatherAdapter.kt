package com.arpitparekh.kotlinafternoonbatch.retrofit_api_weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arpitparekh.kotlinafternoonbatch.databinding.WeatherRowItemBinding

class WeatherAdapter(val list : ArrayList<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    class WeatherViewHolder(binding : WeatherRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val binding = binding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {

        val binding = WeatherRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val viewHolder = WeatherViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val w = list[position]

        holder.binding.obj = w
    }

    override fun getItemCount(): Int {
        return list.size
    }
}