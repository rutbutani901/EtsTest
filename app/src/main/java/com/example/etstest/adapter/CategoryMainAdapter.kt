package com.example.etstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.ItemCategoryBinding
import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.SliderData
import kotlin.collections.ArrayList


class ItemView(val binding: ItemCategoryBinding):
    RecyclerView.ViewHolder(binding.root)

class CategoryMainAdapter (val context: Context, val firstList : ArrayList<String>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<ItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        return ItemView(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {

        val item= firstList[holder.layoutPosition]

        holder.binding.text.text= item

        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}