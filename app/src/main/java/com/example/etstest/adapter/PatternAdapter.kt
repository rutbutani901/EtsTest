package com.example.etstest.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.ItemFabricBinding
import com.example.etstest.databinding.ItemShopBinding


import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.PatternModel
import com.example.etstest.modelClass.ShopModel
import com.example.etstest.modelClass.SliderData
import kotlin.collections.ArrayList


class PatternView(val binding: ItemFabricBinding):
    RecyclerView.ViewHolder(binding.root)

class PatternAdapter (val context: Context, val firstList : List<PatternModel>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<PatternView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatternView {
        return PatternView(
            ItemFabricBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PatternView, position: Int) {

        val item= firstList[holder.layoutPosition]

        Glide.with(context).load(item.imgUrl).into(holder.binding.imgView)
        holder.binding.text.text= item.title

//        holder.binding.text.backgroundTintList=   ContextCompat.getColorStateList(context, Color.parseColor(item.color))
        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}