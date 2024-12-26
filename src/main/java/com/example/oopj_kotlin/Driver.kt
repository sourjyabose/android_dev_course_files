package com.example.oopj_kotlin

import android.util.Log

class Driver(name:String) {
    lateinit var driverName:String
    init{
        driverName=name
    }
    fun showDetails(){
        Log.i("sfp","$driverName")
    }
}