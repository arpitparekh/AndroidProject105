package com.arpitparekh.kotlinafternoonbatch.internal_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityMyInternalBinding
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.properties.Delegates

class MyInternalActivity : AppCompatActivity() {

    lateinit var binding : ActivityMyInternalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMyInternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var number = 1
        var duplicate = 0


        binding.btnStore.setOnClickListener {

            duplicate = number

            val something = binding.edtSomething.text.toString()

            val os : FileOutputStream = openFileOutput("hello$number.txt", MODE_APPEND)

            os.write(something.toByteArray())

            os.close()

            Toast.makeText(this,"$something is been written in file",Toast.LENGTH_SHORT).show()

            number++

        }



        binding.btnFetch.setOnClickListener {

            val ins  : FileInputStream = openFileInput("hello$duplicate.txt")

            val arr : ByteArray = ByteArray(ins.available())

            ins.read(arr)

            val something = String(arr)

            binding.tvData.text = something

        }

    }
}