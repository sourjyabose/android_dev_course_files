package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var spfs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        age = findViewById(R.id.age)
        spfs = getSharedPreferences("sourjya", MODE_PRIVATE)
        editor=spfs.edit()
    }

    override fun onPause() {
        super.onPause()
        val namesp = name.text.toString()
        val agesp = age.text.toString().toInt()
        editor.apply {
            putString("name_spfs", namesp)
            putInt("age_spfs", agesp)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val namepr = spfs.getString("name_spfs", null)
        val agepr = spfs.getInt("age_spfs", 0)
        name.setText(namepr)
        age.setText(agepr.toString())
    }
}