package com.example.ngshuangyin_tp059869.vendor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.MainActivity
import com.example.ngshuangyin_tp059869.R

class ActivityChineseWedVendor : AppCompatActivity() {

    lateinit var adapter : RecyclerView.Adapter<CVViewHolder>
    lateinit var layout_Manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinese_wed_vendor)

        val rvCV = findViewById<RecyclerView>(R.id.rvCV)
        val btncvback = findViewById<Button>(R.id.btnCVBack)

        layout_Manager = LinearLayoutManager(this)
        rvCV.layoutManager = layout_Manager

        adapter = ChineseVendorsRecyclerAdapter()
        rvCV.adapter = adapter

        btncvback.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}