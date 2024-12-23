package com.example.sourjyabose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var user=intent.getStringExtra("abra")
        findViewById<TextView>(R.id.disp).setText(user)
    }
}