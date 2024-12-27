package com.example.viewpagerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerapp.databinding.RecyclerItemViewBinding
import com.example.viewpagerapp.model.ItemData

class RecyclerViewAdapter(private val items: List<ItemData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RecyclerItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(item: ItemData){
                with(binding){
                    titleTextView.text = item.imageTitle
                    imageView.setImageResource(item.imageRes)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int = items.size
}