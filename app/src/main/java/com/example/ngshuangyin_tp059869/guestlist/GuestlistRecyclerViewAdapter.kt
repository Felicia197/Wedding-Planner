package com.example.ngshuangyin_tp059869.guestlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R
import com.example.ngshuangyin_tp059869.databinding.GuestlistItemViewBinding

class GuestlistRecyclerViewAdapter (private val clickListener: (Guestlist)-> Unit)
    : RecyclerView.Adapter <GuestlistViewHolder>() {

    private val guestlist = ArrayList<Guestlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestlistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : GuestlistItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.guestlist_item_view, parent, false)
        return GuestlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuestlistViewHolder, position: Int) {
        holder.bind(guestlist[position],clickListener)
    }

    override fun getItemCount(): Int {
        return guestlist.size
    }

    fun setListForGuestList (guestlists: List<Guestlist>){
        guestlist.clear()
        guestlist.addAll(guestlists)
    }

}

class GuestlistViewHolder (val binding:GuestlistItemViewBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(guestlist: Guestlist, clickListener: (Guestlist)-> Unit){
        binding.tvGuestlistName.text = guestlist.guestName
        binding.tvGuestlistRelationship.text = guestlist.guestRelationship
        binding.guestlistItemLayout.setOnClickListener {
            clickListener(guestlist)
        }
    }
}