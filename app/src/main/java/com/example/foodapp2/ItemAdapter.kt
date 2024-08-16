package com.example.foodapp2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp2.databinding.GridItemBinding

class ItemAdapter(val data : List<MenuItem>,val itemClickListener: ItemClickListener) : ListAdapter<MenuItem, RecyclerView.ViewHolder>(ItemDiffCallback()) {
    class MyViewHolder(val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root){
        companion object{
            fun from(parent: ViewGroup) : MyViewHolder{
                val layoutinflater = LayoutInflater.from(parent.context)
                val binding = GridItemBinding.inflate(layoutinflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }
    interface ItemClickListener{
        fun onItemClick(item: MenuItem)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder.from(parent)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewHolder){
            holder.binding.item = data.get(position)
            holder.binding.root.setOnClickListener{
                itemClickListener.onItemClick(data.get(position))
            }
        }
    }
}
class ItemDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem==newItem
    }
    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem.name==newItem.name && oldItem.img==newItem.img
    }
}