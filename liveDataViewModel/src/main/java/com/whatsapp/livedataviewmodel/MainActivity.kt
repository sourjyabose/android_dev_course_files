package com.whatsapp.livedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewmodel: viewModel = ViewModelProvider(this).get(viewModel::class.java)

        val button: Button = findViewById<Button>(R.id.button)
        val display: TextView = findViewById(R.id.view)
        viewmodel.i.observe(this, Observer{
            display.text=it.toString();
        })
        display.text= viewmodel.i.toString();
        button.setOnClickListener {
            viewmodel.click()

        }

    }

}