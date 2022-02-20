package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var ip = findViewById<EditText>(R.id.text)
        val ipkvant = findViewById<Button>(R.id.but2)
        val prod = findViewById<Button>(R.id.but)
        val ipdom = findViewById<Button>(R.id.but3)
        var dom = "192.168.100.6"
        var kvant = "192.168.100.6"
        ipkvant.setOnClickListener {
            kik = kvant
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        ipdom.setOnClickListener {
            kik = dom
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }


        prod.setOnClickListener {
            if (ip.text == null){
                ip.error ="НАПИШИ IP"
            }
            if (ip.text != null){
                kik = ip.text.toString()
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)

            }
            }
        }
        }



