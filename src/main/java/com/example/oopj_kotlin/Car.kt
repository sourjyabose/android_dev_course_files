package com.example.oopj_kotlin

import android.util.Log

open class Car {
    var maxSpeed=90
  open  fun start(){
        Log.i("sfp","$maxSpeed")
    }
}