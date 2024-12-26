package com.example.oopj_kotlin

import android.util.Log

class childCar:Car(),carDetails {

override fun start(){
    Log.i("sfp","${this.company()}")

}

    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun deacc() {
        TODO("Not yet implemented")
    }
}