package com.arpitparekh.kotlinafternoonbatch.login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {

            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {

                if(it.isSuccessful){
                    Toast.makeText(this,"Login SuccessFull",Toast.LENGTH_SHORT).show()
                }


            }.addOnFailureListener {
                Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()

            }

        }

        binding.tvNewUser.setOnClickListener {

            startActivity(Intent(this,SignupActivity ::class.java))
        }

    }
}