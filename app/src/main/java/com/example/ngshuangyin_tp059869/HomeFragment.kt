package com.example.ngshuangyin_tp059869

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import java.security.Key


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)


        var btnStart = view.findViewById<Button>(R.id.btnStart)
        var etvName = view.findViewById<EditText>(R.id.etvName)
        var etvPartnerName = view.findViewById<EditText>(R.id.etvPartnerName)
        var etvMarriageDate = view.findViewById<EditText>(R.id.etvMarriageDate)
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvPartnerName = view.findViewById<TextView>(R.id.tvPartnerName)
        var tvMarriageDate = view.findViewById<TextView>(R.id.tvMarriageDate)

        // Load Data
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedName : String? = sharedPreferences.getString("Username",null)
        val savedPartnerName : String? = sharedPreferences.getString("Partner's Name",null)
        val savedMarriageDate : String? = sharedPreferences.getString("Marriage Date",null)

        tvName.text = savedName
        tvPartnerName.text = savedPartnerName
        tvMarriageDate.text = savedMarriageDate


        btnStart.setOnClickListener {

            val name = etvName.text.toString()
            val partnername = etvPartnerName.text.toString()
            val marriagedate = etvMarriageDate.text.toString()

            if (name.isNotEmpty() && partnername.isNotEmpty() && marriagedate.isNotEmpty()) {

                val insertedName: String = etvName.text.toString()
                tvName.text = insertedName
                val insertedPartnerName: String = etvPartnerName.text.toString()
                tvPartnerName.text = insertedPartnerName
                val insertedMarriageDate: String = etvMarriageDate.text.toString()
                tvMarriageDate.text = insertedMarriageDate

                val sharedPreferences: SharedPreferences =
                    requireContext().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.apply {
                    putString("Username", insertedName)
                    putString("Partner's Name", insertedPartnerName)
                    putString("Marriage Date", insertedMarriageDate)
                }.apply()

                Toast.makeText(context, "Details Saved", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(context, "Please Enter Data To Edit!", Toast.LENGTH_LONG).show()
            }

        }

        return view
    }



    companion object {

        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }
}

