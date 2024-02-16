package com.example.ngshuangyin_tp059869

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ngshuangyin_tp059869.budget.*
import com.example.ngshuangyin_tp059869.budget.BudgetViewModel
import com.example.ngshuangyin_tp059869.databinding.FragmentBudgetBinding


class BudgetFragment : Fragment() {

    private lateinit var binding: FragmentBudgetBinding
    private lateinit var budgetViewModel: BudgetViewModel
    private lateinit var adapter: BudgetRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //val binding = inflater.inflate(R.layout.fragment_budget, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_budget, container,false)
        val dao = BudgetDatabase.getInstance(container!!.context).budgetDao
        val repository = BudgetRepository(dao)
        val factory = BudgetViewModelFactory(repository)
        budgetViewModel = ViewModelProvider(this,factory).get(BudgetViewModel::class.java)
        binding.budgetViewModel = budgetViewModel
        binding.lifecycleOwner = this
        displayBudget()
        initRecyclerView()

        budgetViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

    private fun initRecyclerView(){
        binding.budgetRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BudgetRecyclerViewAdapter (
            {selectedItem:Budget->budgetItemClicked(selectedItem)}
        )
        binding.budgetRecyclerView.adapter = adapter
        displayBudget()
    }

    private fun displayBudget(){

        budgetViewModel.budgets.observe(viewLifecycleOwner, Observer {
            Log.i("MYBUDGETTAG", it.toString())
            adapter.setListForBudget(it)
            adapter.notifyDataSetChanged()
        })

    }

    private fun budgetItemClicked (budget: Budget){
        //Toast.makeText(context, "Selected Task is ${budget.task}", Toast.LENGTH_LONG).show()
        budgetViewModel.initUpdateAndDelete(budget)
    }


    companion object {

        @JvmStatic
        fun newInstance(): BudgetFragment {
            return BudgetFragment()
        }
    }
}