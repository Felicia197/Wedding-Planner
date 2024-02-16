package com.example.ngshuangyin_tp059869.vendor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R

class IndianVendorsRecyclerAdapter : RecyclerView.Adapter<CIViewHolder>() {

    val CIname : Array<String> = arrayOf("Lit Indian Wed","Andaaz Bride","365 Indian Bridal"
        ,"Lisha's Bridal","Nishaa Beauty Bridal","Lora Indian Wed")

    val CIcontact : Array<String> = arrayOf("03-1238217","011-2370642","03-4587346"
        ,"016-0023744","017-111225","03-0037564")

    val CIrating : Array<String> = arrayOf("3.5/5","5/5","4.5/5","2/5","4/5","2.5/5","3/5")

    val CIpic : IntArray = intArrayOf(
        R.drawable.cione,R.drawable.citwo,R.drawable.cithree
        ,R.drawable.cifour,R.drawable.cifive,R.drawable.cisix)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CIViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.indian_vendor_view,parent, false)
        return CIViewHolder(v)
    }

    override fun onBindViewHolder(holder: CIViewHolder, position: Int) {
        holder.nameCI.text = CIname[position]
        holder.imgCI.setImageResource(CIpic[position])
        holder.contactCI.text = CIcontact[position]
        holder.ratingCI.text = CIrating[position]
    }

    override fun getItemCount(): Int {
        return CIname.size
    }


}


class CIViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var imgCI : ImageView
    var nameCI : TextView
    var contactCI : TextView
    var ratingCI : TextView

    init {
        imgCI = itemView.findViewById(R.id.imCI)
        nameCI = itemView.findViewById(R.id.tvCIname)
        contactCI = itemView.findViewById(R.id.tvCIcontact)
        ratingCI = itemView.findViewById(R.id.tvCIrating)
    }
}