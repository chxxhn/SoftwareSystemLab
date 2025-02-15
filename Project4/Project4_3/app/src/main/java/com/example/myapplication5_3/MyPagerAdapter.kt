package com.example.myapplication5_3

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication5_3.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyPagerViewHolder(ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding

        binding.itemPagerTextView.text = datas[position]
        when (position % 3) {
            0 -> binding.root.setBackgroundColor(Color.RED)
            1 -> binding.root.setBackgroundColor(Color.BLUE)
            2 -> binding.root.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}