package com.arpitparekh.kotlinafternoonbatch.external_storage_api29

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityExternalBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class ExternalActivity : AppCompatActivity() {

    lateinit var binding : ActivityExternalBinding
    lateinit var permission : ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExternalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        permission  = registerForActivityResult(ActivityResultContracts.RequestPermission(),object : ActivityResultCallback<Boolean>{

            override fun onActivityResult(result: Boolean?) {

                if(result==true){

                    Toast.makeText(this@ExternalActivity,"Granted",Toast.LENGTH_SHORT).show()

                }else{

                    Toast.makeText(this@ExternalActivity,"Denied",Toast.LENGTH_SHORT).show()

                }
            }
        })

        // permission

        checkExternalPermission()

        binding.btnSend.setOnClickListener {

            val data : String = binding.edtSomething.text.toString()

            try{

                val file : File = File(Environment.getExternalStorageDirectory().toString(),"/data")

                if(!file.exists()){

                    file.mkdir()
                }

                val child = File(file,"hello.txt")

                val os  = FileOutputStream(child)

                os.write(data.toByteArray())

                os.close()

                Toast.makeText(this@ExternalActivity,"File Write Successfully",Toast.LENGTH_SHORT).show()

            }catch (e : Exception){

                Log.i("error",e.toString())

            }
        }

        binding.btnReceive.setOnClickListener {

            val file : File = File(Environment.getExternalStorageDirectory().toString(),"/data")

            if(!file.exists()){

                file.mkdir()
            }

            val child = File(file,"hello.txt")

            val ins = FileInputStream(child)

            val arr = ByteArray(ins.available())

            ins.read(arr)

            val str = String(arr)

            binding.tvSomething.text = str

        }


    }



    private fun checkExternalPermission() {

        permission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    }
}