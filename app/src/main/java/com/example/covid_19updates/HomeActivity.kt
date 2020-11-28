package com.example.covid_19updates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.viewAll).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        findViewById<Button>(R.id.global).setOnClickListener {
            startActivity(Intent(this,GlobalActivity::class.java))
        }
    }
}