package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.View
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    fun valid(weight:String, height:String?):Boolean{
        return when{
        weight.isNullOrEmpty()->{
            Toast.makeText(this,"Weight is Empty",Toast.LENGTH_LONG).show()
            return false
        }

            height.isNullOrEmpty()->{
                Toast.makeText(this,"Height is Empty",Toast.LENGTH_LONG).show()
                return false
            }
            else->{
                return true
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val weight=findViewById<EditText>(R.id.weight).text.toString()
            val height=findViewById<EditText>(R.id.height).text.toString()
            val BMI=findViewById<TextView>(R.id.BMI)

            val healthy=findViewById<TextView>(R.id.healthy)
            if (valid(weight,height)){
            val bmicalc=weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
            displayBMI(bmicalc,BMI,healthy)
            }
        }
    }

    private fun displayBMI(bmi: Float,Screen: TextView,Message: TextView) {
        var disp=String.format("%.2f",bmi)
        Screen.text=disp
        Message.visibility=VISIBLE
        when {
            bmi < 18.4->{
            Message.text="Kha le kuch"
                Message.setTextColor(ContextCompat.getColor(this,R.color.uw))
            }
            bmi in 18.5..24.99->{
                Message.text="You are fit ! ! !\n Have a Chit Day"
                Message.setTextColor(ContextCompat.getColor(this,R.color.fit))
            }
            bmi > 25.00->{
                Message.text="Janab thoda kam khaiye"

                Message.setTextColor(0xFFEE1201.toInt())
            }

        }
    }

}