package com.example.sharepreferencesproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Fetch data from SharedPreferences
        val myshare = getSharedPreferences("local_yat", 0)
        val email = myshare.getString("Email", "No Email")
        val password = myshare.getString("password", "No Password")

        // Set the fetched data to TextViews
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val passwordTextView = findViewById<TextView>(R.id.passwordTextView)

        emailTextView.text = "Email: $email"
        passwordTextView.text = "Password: $password"

        // Delete data when the button is clicked
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        deleteButton.setOnClickListener {
            val editor: SharedPreferences.Editor = myshare.edit()
            editor.clear() // Clear all data in SharedPreferences
            editor.commit()

            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close DisplayActivity
        }
    }
}
