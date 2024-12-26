package com.example.sourjyabose

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtView=findViewById<TextView>(R.id.textView)
        val inp=findViewById<EditText>(R.id.alpha)
        val subb=findViewById<Button>(R.id.sub)
        val butt=findViewById<Button>(R.id.offer)
        var names:String="";
        subb.setOnClickListener{
            names=inp.text.toString();
            if(names=="") {
                txtView.text=""
                Toast.makeText(this@MainActivity,"nnnn nnnnk s b",Toast.LENGTH_SHORT).show()
            }else {

                txtView.text = "Hello , $names"
                inp.text.clear()
                butt.visibility=0;
                }
            }
        butt.setOnClickListener{
            val intenti= Intent(this,secondActivity::class.java)
            intenti.putExtra("abra",names)
            startActivity(intenti)
        }

    }
    override fun onRestart(){
        super.onStart()
        Log.i("sfsg","Re-Starting")
    }
    override fun onStart(){
        super.onStart()
        Log.i("sfsg","Starting")
    }
    override fun onResume(){
        super.onResume()
        Log.i("sfsg","Resuming")
    }
    override fun onStop(){
        super.onStop()
        Log.i("sfsg","Stoping")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.i("sfsg","Destroying")
    }
}