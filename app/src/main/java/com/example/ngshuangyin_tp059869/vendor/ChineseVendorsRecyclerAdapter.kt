package com.example.ngshuangyin_tp059869.vendor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R

class ChineseVendorsRecyclerAdapter : RecyclerView.Adapter<CVViewHolder>() {

    val CVname : Array<String> = arrayOf("LF Wedding & Services","HeiXi Chinese Wedding","88 Signature Bridal"
        ,"HuanYuan Chinese Sdn Bhd","OneHeart Chinese Wed","Traditional CN Wed")

    val CVcontact : Array<String> = arrayOf("03-3848462","012-2374064","03-2749569"
        ,"016-4057603","017-4785600","03-9902918")

    val CVrating : Array<String> = arrayOf("4.5/5","3/5","5/5","3.5/5","4.5/5","5/5","3/5")

    val CVpic : IntArray = intArrayOf(
        R.drawable.cvone,R.drawable.cvtwo,R.drawable.cvthree
        ,R.drawable.cvfour,R.drawable.cvfive,R.drawable.cvsix)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chinese_vendor_view,parent, false)
        return CVViewHolder(v)
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.nameCV.text = CVname[position]
        holder.imgCV.setImageResource(CVpic[position])
        holder.contactCV.text = CVcontact[position]
        holder.ratingCV.text = CVrating[position]
    }

    override fun getItemCount(): Int {
        return CVname.size
    }

}


class CVViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var imgCV : ImageView
    var nameCV : TextView
    var contactCV : TextView
    var ratingCV : TextView

    init {
        imgCV = itemView.findViewById(R.id.imCV)
        nameCV = itemView.findViewById(R.id.tvCVname)
        contactCV = itemView.findViewById(R.id.tvCVcontact)
        ratingCV = itemView.findViewById(R.id.tvCVrating)
    }
}



