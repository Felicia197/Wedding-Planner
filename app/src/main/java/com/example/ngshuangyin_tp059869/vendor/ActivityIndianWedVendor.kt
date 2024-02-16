package com.example.ngshuangyin_tp059869.vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.MainActivity
import com.example.ngshuangyin_tp059869.R

class ActivityIndianWedVendor : AppCompatActivity() {

    lateinit var adapter : RecyclerView.Adapter<CIViewHolder>
    lateinit var layout_Manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indian_wed_vendor)

        val rvCI = findViewById<RecyclerView>(R.id.rvCI)
        val btnciback = findViewById<Button>(R.id.btnCIBack)

        layout_Manager = LinearLayoutManager(this)
        rvCI.layoutManager = layout_Manager

        adapter = IndianVendorsRecyclerAdapter()
        rvCI.adapter = adapter

        btnciback.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}