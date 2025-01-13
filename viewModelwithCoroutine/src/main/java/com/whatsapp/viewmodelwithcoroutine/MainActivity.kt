package com.whatsapp.viewmodelwithcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModeli:viewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModeli= ViewModelProvider(this).get(viewModel::class.java)
        setContentView(R.layout.activity_main)

        viewModeli.usrs.observe(this, Observer{
                it.forEach{
                    Log.i("sourjya",it.name)
                }
        })
        viewModeli.getUserData()
    }
}