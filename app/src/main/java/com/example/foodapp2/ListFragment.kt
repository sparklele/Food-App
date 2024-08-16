package com.example.foodapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp2.databinding.ListFragmentBinding


class ListFragment : Fragment(), ItemAdapter.ItemClickListener {
    lateinit var binding : ListFragmentBinding
    lateinit var data : MutableList<MenuItem>
    lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater,container,false)
        data= mutableListOf(
            MenuItem(R.drawable.burger,"Burger"),
            MenuItem(R.drawable.filletsteak,"Steak"),
            MenuItem(R.drawable.pancakes,"Pancakes"),
            MenuItem(R.drawable.pizza,"Pizza"),
            MenuItem(R.drawable.shawerma,"Shawerma"),
            MenuItem(R.drawable.waffles,"Waffles")
        )
        itemAdapter = ItemAdapter(data,this)
        binding.gridlist.adapter = itemAdapter
        //adapter.submitList(data)
        binding.gridlist.layoutManager = GridLayoutManager(context,2)
        return binding.root
    }

    override fun onItemClick(item: MenuItem) {
        val action = ListFragmentDirections.actionListFragmentToMenuFragment(item)
        findNavController().navigate(action)
    }
}