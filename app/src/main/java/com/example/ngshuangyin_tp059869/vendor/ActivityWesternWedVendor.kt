package com.example.ngshuangyin_tp059869.vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.MainActivity
import com.example.ngshuangyin_tp059869.R

class ActivityWesternWedVendor : AppCompatActivity() {

    lateinit var adapter: RecyclerView.Adapter<CWViewHolder>
    lateinit var layout_Manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_western_wed_vendor)

        val rvCW = findViewById<RecyclerView>(R.id.rvCW)
        val btncwback = findViewById<Button>(R.id.btnCWBack)

        layout_Manager = LinearLayoutManager(this)
        rvCW.layoutManager = layout_Manager

        adapter = WesternVendorsRecyclerAdapter()
        rvCW.adapter = adapter

        btncwback.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}