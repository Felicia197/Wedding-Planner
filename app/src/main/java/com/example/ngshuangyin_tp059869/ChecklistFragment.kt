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
import com.example.ngshuangyin_tp059869.checklist.*
import com.example.ngshuangyin_tp059869.checklist.ChecklistViewModel
import com.example.ngshuangyin_tp059869.databinding.FragmentChecklistBinding


class ChecklistFragment : Fragment() {

    private lateinit var binding: FragmentChecklistBinding
    private lateinit var checklistViewModel: ChecklistViewModel
    private lateinit var adapter: ChecklistRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //val binding = inflater.inflate(R.layout.fragment_checklist, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_checklist, container,false)
        val dao = ChecklistDatabase.getInstance(container!!.context).checklistDao
        val repository = ChecklistRepository(dao)
        val factory = ChecklistViewModelFactory(repository)
        checklistViewModel = ViewModelProvider(this,factory).get(ChecklistViewModel::class.java)
        binding.checklistViewModel = checklistViewModel
        binding.lifecycleOwner = this
        displayChecklist()
        initRecyclerView()

        checklistViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

    private fun initRecyclerView(){
        binding.checklistRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ChecklistRecyclerViewAdapter (
            {selectedItem:Checklist->checklistItemClicked(selectedItem)}
        )
        binding.checklistRecyclerView.adapter = adapter
        displayChecklist()
    }

    private fun displayChecklist(){

        checklistViewModel.checklists.observe(viewLifecycleOwner, Observer {
            Log.i("MYCHECKLISTTAG", it.toString())
            adapter.setListForCheckList(it)
            adapter.notifyDataSetChanged()
        })

    }

    private fun checklistItemClicked (checklist: Checklist){
        checklistViewModel.initUpdateAndDelete(checklist)
    }


    companion object {

        @JvmStatic
        fun newInstance(): ChecklistFragment {
            return ChecklistFragment()
        }
    }
}