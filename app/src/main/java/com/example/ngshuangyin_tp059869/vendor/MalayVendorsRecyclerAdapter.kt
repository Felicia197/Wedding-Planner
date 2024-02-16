package com.example.ngshuangyin_tp059869.vendor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R

class MalayVendorsRecyclerAdapter : RecyclerView.Adapter<CMViewHolder>() {

    val CMname : Array<String> = arrayOf("Precious Malay Wed","Hasni Wed","Wedding Mall"
        ,"Muslimah Bridal","Beauty Bridal","Jus Malay Wed")

    val CMcontact : Array<String> = arrayOf("03-1311105","011-5467642","03-4587346"
        ,"016-0023744","017-111225","03-0037564")

    val CMrating : Array<String> = arrayOf("4.5/5","3.5/5","4.5/5","2/5","4/5","3.5/5","3/5")

    val CMpic : IntArray = intArrayOf(
        R.drawable.cmone,R.drawable.cmtwo,R.drawable.cmthree
        ,R.drawable.cmfour,R.drawable.cmfive,R.drawable.cmsix)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CMViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.malay_vendor_view,parent, false)
        return CMViewHolder(v)
    }

    override fun onBindViewHolder(holder: CMViewHolder, position: Int) {
        holder.nameCM.text = CMname[position]
        holder.imgCM.setImageResource(CMpic[position])
        holder.contactCM.text = CMcontact[position]
        holder.ratingCM.text = CMrating[position]
    }

    override fun getItemCount(): Int {
        return CMname.size
    }


}


class CMViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var imgCM : ImageView
    var nameCM : TextView
    var contactCM : TextView
    var ratingCM : TextView

    init {
        imgCM = itemView.findViewById(R.id.imCM)
        nameCM = itemView.findViewById(R.id.tvCMname)
        contactCM = itemView.findViewById(R.id.tvCMcontact)
        ratingCM = itemView.findViewById(R.id.tvCMrating)
    }
}