package com.example.ngshuangyin_tp059869.vendor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R

class WesternVendorsRecyclerAdapter : RecyclerView.Adapter<CWViewHolder>() {

    val CWname : Array<String> = arrayOf("AMAZINGWED","Judy Bridal","Your Bride"
        ,"USA Wedding","DREAM WEDDING","Oh My Bride")

    val CWcontact : Array<String> = arrayOf("03-1265564","011-3342289","03-5837539"
        ,"016-1232898","017-5546732","03-9997305")

    val CWrating : Array<String> = arrayOf("3/5","5/5","4/5","2.5/5","4.5/5","2.5/5","5/5")

    val CWpic : IntArray = intArrayOf(
        R.drawable.cwone,R.drawable.cwtwo,R.drawable.cwthree
        ,R.drawable.cwfour,R.drawable.cwfive,R.drawable.cwsix)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CWViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.western_vendor_view,parent, false)
        return CWViewHolder(v)
    }

    override fun onBindViewHolder(holder: CWViewHolder, position: Int) {
        holder.nameCW.text = CWname[position]
        holder.imgCW.setImageResource(CWpic[position])
        holder.contactCW.text = CWcontact[position]
        holder.ratingCW.text = CWrating[position]
    }

    override fun getItemCount(): Int {
        return CWname.size
    }


}


class CWViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var imgCW : ImageView
    var nameCW : TextView
    var contactCW : TextView
    var ratingCW : TextView

    init {
        imgCW = itemView.findViewById(R.id.imCW)
        nameCW = itemView.findViewById(R.id.tvCWname)
        contactCW = itemView.findViewById(R.id.tvCWcontact)
        ratingCW = itemView.findViewById(R.id.tvCWrating)
    }
}