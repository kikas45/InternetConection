package com.example.internetconnection

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkConnectionStatus = findViewById<TextView>(R.id.tv)



        Thread(Runnable {

            while (true){

                var  conStant: String = "Not Connected"

                val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val netInfo = cm.allNetworkInfo

                for (ni in netInfo){

                    //case 1
                    if (ni.typeName.equals("WIFI", ignoreCase = true))
                    { if (ni.isConnected)conStant = "WIFI"}

                    //case 2

                    if (ni.typeName.equals("MOBILE", ignoreCase = true))
                    {
                        if (ni.isConnected) conStant = "MOBILE DATA"
                    }
                    runOnUiThread{
                        networkConnectionStatus.text = conStant
                    }

                }





            }
        }).start()
    }
}