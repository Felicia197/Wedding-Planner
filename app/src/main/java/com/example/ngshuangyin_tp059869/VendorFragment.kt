package com.example.ngshuangyin_tp059869

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ngshuangyin_tp059869.databinding.FragmentVendorBinding
import com.example.ngshuangyin_tp059869.vendor.ActivityChineseWedVendor
import com.example.ngshuangyin_tp059869.vendor.ActivityIndianWedVendor
import com.example.ngshuangyin_tp059869.vendor.ActivityMalayWedVendor
import com.example.ngshuangyin_tp059869.vendor.ActivityWesternWedVendor

class VendorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentVendorBinding.inflate(layoutInflater)

        bind.CardChinese.setOnClickListener {
            val inten =
                Intent(this@VendorFragment.requireContext(), ActivityChineseWedVendor::class.java)
            startActivity(inten)
        }

        bind.CardWestern.setOnClickListener {
            val inten =
                Intent(this@VendorFragment.requireContext(), ActivityWesternWedVendor::class.java)
            startActivity(inten)
        }

        bind.CardMalay.setOnClickListener {
            val inten =
                Intent(this@VendorFragment.requireContext(), ActivityMalayWedVendor::class.java)
            startActivity(inten)
        }

        bind.CardIndian.setOnClickListener {
            val inten =
                Intent(this@VendorFragment.requireContext(), ActivityIndianWedVendor::class.java)
            startActivity(inten)
        }

        return bind.root
    }
}

//    companion object {
//
//        @JvmStatic
//        fun newInstance(): VendorFragment {
//            return VendorFragment()
//        }
//    }
//}