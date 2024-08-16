package com.example.foodapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.foodapp2.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {
    lateinit var binding: MenuFragmentBinding
    private val args: MenuFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= MenuFragmentBinding.inflate(inflater,container,false)
        val item = args.item
        binding.fragFoodIMG.setImageResource(item.img)
        binding.fragFoodTV.text = item.name
        return binding.root
    }
}