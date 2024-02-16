package com.example.ngshuangyin_tp059869.budget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ngshuangyin_tp059869.R
import com.example.ngshuangyin_tp059869.databinding.BudgetItemViewBinding

class BudgetRecyclerViewAdapter (private val clickListener: (Budget)-> Unit)
    : RecyclerView.Adapter <BudgetViewHolder>() {

    private val budget = ArrayList<Budget>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : BudgetItemViewBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.budget_item_view, parent, false)
        return BudgetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(budget[position],clickListener)
    }

    override fun getItemCount(): Int {
        return budget.size
    }

    fun setListForBudget (budgets: List<Budget>){
        budget.clear()
        budget.addAll(budgets)
    }

}

class BudgetViewHolder (val binding: BudgetItemViewBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(budget: Budget, clickListener: (Budget)-> Unit){
        binding.tvBudgetDetails.text = budget.budgetDetails
        binding.tvBudgetAmount.text = budget.budgetAmount.toString()
        binding.budgetItemLayout.setOnClickListener {
            clickListener(budget)
        }
    }
}