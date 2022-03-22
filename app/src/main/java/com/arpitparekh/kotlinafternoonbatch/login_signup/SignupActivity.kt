package com.arpitparekh.kotlinafternoonbatch.login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arpitparekh.kotlinafternoonbatch.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {

            val email = binding.edtEmailSignup.text.toString()
            val password = binding.edtPasswordSignup.text.toString()

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {

                if(it.isSuccessful){
                    Toast.makeText(this,"Register Success",Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this,LoginActivity ::class.java))
                }


            }.addOnFailureListener {

                Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()

            }



        }
    }
}