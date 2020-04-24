package com.example.workmanager

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
lateinit var  btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    btn = findViewById(R.id.button)
        btn.setOnClickListener {
            showNotification()
        }
       private fun  showNotification(){
       val notificationManager : NotificationManager =
           getSystemService(Context.NOTIFICATION_SERVICE)

       }


    }
}
