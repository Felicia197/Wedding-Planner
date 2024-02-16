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
import com.example.ngshuangyin_tp059869.guestlist.*
import com.example.ngshuangyin_tp059869.guestlist.GuestlistViewModel
import com.example.ngshuangyin_tp059869.databinding.FragmentGuestlistBinding


class GuestlistFragment : Fragment() {

    private lateinit var binding: FragmentGuestlistBinding
    private lateinit var guestlistViewModel: GuestlistViewModel
    private lateinit var adapter: GuestlistRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //val binding = inflater.inflate(R.layout.fragment_guestlist, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_guestlist, container,false)
        val dao = GuestlistDatabase.getInstance(container!!.context).guestlistDao
        val repository = GuestlistRepository(dao)
        val factory = GuestlistViewModelFactory(repository)
        guestlistViewModel = ViewModelProvider(this,factory).get(GuestlistViewModel::class.java)
        binding.guestlistViewModel = guestlistViewModel
        binding.lifecycleOwner = this
        displayGuestlist()
        initRecyclerView()

        guestlistViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

    private fun initRecyclerView(){
        binding.guestlistRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = GuestlistRecyclerViewAdapter (
            {selectedItem:Guestlist->guestlistItemClicked(selectedItem)}
        )
        binding.guestlistRecyclerView.adapter = adapter
        displayGuestlist()
    }

    private fun displayGuestlist(){

        guestlistViewModel.guestlists.observe(viewLifecycleOwner, Observer {
            Log.i("MYGUESTLISTTAG", it.toString())
            adapter.setListForGuestList(it)
            adapter.notifyDataSetChanged()
        })

    }

    private fun guestlistItemClicked (guestlist: Guestlist){
        //Toast.makeText(context, "Selected Task is ${guestlist.task}", Toast.LENGTH_LONG).show()
        guestlistViewModel.initUpdateAndDelete(guestlist)
    }


    companion object {

        @JvmStatic
        fun newInstance(): GuestlistFragment {
            return GuestlistFragment()
        }
    }
}