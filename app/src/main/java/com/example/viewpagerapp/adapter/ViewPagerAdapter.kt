package com.example.viewpagerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerapp.databinding.ViewPagerItemBinding
import com.example.viewpagerapp.model.ViewPagerItemModel

class ViewPagerAdapter(
    private val pageData: List<ViewPagerItemModel>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewPagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ViewPagerItemModel) {
            with(binding) {
                recyclerView.layoutManager = GridLayoutManager(
                    /* context = */ itemView.context,
                    /* spanCount = */ 2,
                    /* orientation = */ GridLayoutManager.VERTICAL,
                    /* reverseLayout = */ false
                )
                recyclerView.adapter = RecyclerViewAdapter(item.data)

                titleTextView.text = item.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPagerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(pageData[position])
    }

    override fun getItemCount(): Int = pageData.size
}