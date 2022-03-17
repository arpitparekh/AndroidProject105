package com.arpitparekh.kotlinafternoonbatch.JsonParsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityJsonParseBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray

class JsonParseActivity : AppCompatActivity() {
    lateinit var binding : ActivityJsonParseBinding
    lateinit var list : ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonParseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        val adapter = ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1,list)

        binding.listviewJson.adapter = adapter

        Thread(Runnable {

            val client : OkHttpClient = OkHttpClient()

            val request : Request = Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build()

            val respose : Response = client.newCall(request).execute()

            val json = respose.body!!.string()

            val array : JSONArray = JSONArray(json)

            for(i in 0 until array.length()){

                val jsonObject = array.getJSONObject(i)

                val userId = jsonObject.getString("userId")
                val id = jsonObject.getString("id")
                val title = jsonObject.getString("title")
                val body = jsonObject.getString("body")

                val n = Note(title,body)
                list.add(n)
            }

            runOnUiThread {

                adapter.notifyDataSetChanged()
            }

        }).start()




    }
}