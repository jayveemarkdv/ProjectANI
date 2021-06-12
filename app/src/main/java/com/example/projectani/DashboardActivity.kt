package com.example.projectani

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

class DashboardActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val tvDisplayDate = findViewById<TextView>(R.id.dateText)
        val date = System.currentTimeMillis()

        val sdf = SimpleDateFormat("MMM MM dd, yyyy h:mm a")
        val dateString: String = sdf.format(date)
        tvDisplayDate.text = dateString
    }
}