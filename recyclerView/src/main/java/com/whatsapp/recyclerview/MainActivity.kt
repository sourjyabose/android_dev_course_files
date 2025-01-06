package com.whatsapp.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recycle: RecyclerView
    val students=listOf<data>(data("Sourjya","❤️ Shruti"),data("Akarsh","Tanmay"),data("Krish","Raushan"),data("Maitri ","Yagna"),data("Vansh","Vaidehi"),data("Diyansh","rose"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle=findViewById(R.id.recyclerView)
        recycle.setBackgroundColor(0xFFA8EE4E.toInt())
        recycle.layoutManager=LinearLayoutManager(this)
        recycle.adapter=adapter(students,{studenti:data->click(studenti)})
    }
    private fun click(fruit:data){
        Toast.makeText(this,fruit.desg,Toast.LENGTH_SHORT).show()
    }
}