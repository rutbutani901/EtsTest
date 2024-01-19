package com.example.etstest.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.ItemOccasionBinding
import com.example.etstest.databinding.ItemShopBinding
import com.example.etstest.modelClass.OccasionModel


import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.ShopModel
import com.example.etstest.modelClass.SliderData
import kotlin.collections.ArrayList


class OcassionView(val binding: ItemOccasionBinding):
    RecyclerView.ViewHolder(binding.root)

class OccasionAdapter (val context: Context, val firstList : List<OccasionModel>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<OcassionView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OcassionView {
        return OcassionView(
            ItemOccasionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OcassionView, position: Int) {

        val item= firstList[holder.layoutPosition]

        Glide.with(context).load(item.img).into(holder.binding.imgView)
        holder.binding.text.text= item.name

//        holder.binding.text.backgroundTintList=   ContextCompat.getColorStateList(context, Color.parseColor(item.color))
        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}