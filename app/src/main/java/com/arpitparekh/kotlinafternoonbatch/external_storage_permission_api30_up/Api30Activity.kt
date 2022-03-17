package com.arpitparekh.kotlinafternoonbatch.external_storage_permission_api30_up

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityApi30Binding


class Api30Activity : AppCompatActivity() {

    lateinit var binding : ActivityApi30Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApi30Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPermission.setOnClickListener {

            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.data = Uri.parse(String.format("package:%s", applicationContext.packageName))
            startActivity(intent)

        }

    }
}