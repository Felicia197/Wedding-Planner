package com.example.ngshuangyin_tp059869.checklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R
import com.example.ngshuangyin_tp059869.databinding.ChecklistItemViewBinding

class ChecklistRecyclerViewAdapter (private val clickListener: (Checklist)-> Unit)
    : RecyclerView.Adapter <ChecklistViewHolder>() {

    private val checklist = ArrayList<Checklist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChecklistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ChecklistItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.checklist_item_view, parent, false)
        return ChecklistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChecklistViewHolder, position: Int) {
        holder.bind(checklist[position],clickListener)
    }

    override fun getItemCount(): Int {
        return checklist.size
    }

    fun setListForCheckList (checklists: List<Checklist>){
        checklist.clear()
        checklist.addAll(checklists)
    }

}

class ChecklistViewHolder (val binding:ChecklistItemViewBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(checklist:Checklist, clickListener: (Checklist)-> Unit){
        binding.tvChecklistTask.text = checklist.task
        binding.tvChecklistDate.text = checklist.date
        binding.checklistItemLayout.setOnClickListener {
            clickListener(checklist)
        }
    }
}