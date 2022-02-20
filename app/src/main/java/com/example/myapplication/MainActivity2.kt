package com.example.myapplication


    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import io.ktor.client.*
    import io.ktor.client.engine.cio.*
    import io.ktor.client.features.*


    import io.ktor.client.request.*
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.MainScope
    import kotlinx.coroutines.launch
    import kotlinx.coroutines.withContext


    class MainActivity2 : AppCompatActivity() {

        val client = HttpClient(CIO){
            install(HttpTimeout){
                requestTimeoutMillis = 15000
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)




            MainScope().launch(Dispatchers.IO) {
                val response = client.get<String>(host = "$kik", port = 8080){
                    timeout {
                        requestTimeoutMillis = 13000
                    }
                }
                withContext(Dispatchers.Main){
                    findViewById<TextView>(R.id.text).text = response
                }

            }
            findViewById<Button>(R.id.but).setOnClickListener {
                MainScope().launch(Dispatchers.IO) {
                    client.get(host = "$kik", port = 8080, path = "/newState") {
                        timeout {
                            requestTimeoutMillis = 113000
                        }
                        val text = withContext(Dispatchers.Main){
                            findViewById<EditText>(R.id.text2).text.toString()
                        }
                        parameter("state", text)
                    }


                }
            }

        }}
var kik = ""




