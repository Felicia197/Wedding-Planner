package com.example.ngshuangyin_tp059869.vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.MainActivity
import com.example.ngshuangyin_tp059869.R

class ActivityMalayWedVendor : AppCompatActivity() {

    lateinit var adapter : RecyclerView.Adapter<CMViewHolder>
    lateinit var layout_Manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malay_wed_vendor)

        val rvCM = findViewById<RecyclerView>(R.id.rvCM)
        val btncmback = findViewById<Button>(R.id.btnCMBack)

        layout_Manager = LinearLayoutManager(this)
        rvCM.layoutManager = layout_Manager

        adapter = MalayVendorsRecyclerAdapter()
        rvCM.adapter = adapter

        btncmback.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}