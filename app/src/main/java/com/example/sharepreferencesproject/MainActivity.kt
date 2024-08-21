package com.example.sharepreferencesproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var myshare: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            myshare = getSharedPreferences("local_yat", 0)
            val editor: SharedPreferences.Editor? = myshare!!.edit()

            val textEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
            val userEmail = textEmail.text.toString()

            val textPassword = findViewById<EditText>(R.id.password)
            val userPassword = textPassword.text.toString()

            editor!!.putString("Email", userEmail)
            editor!!.putString("password", userPassword)
            editor.commit()

            // Navigate to DisplayActivity
            val intent = Intent(this, DisplayActivity::class.java)
            startActivity(intent)
        }
    }
}
