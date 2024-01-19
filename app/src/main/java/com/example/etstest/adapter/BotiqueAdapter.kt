package com.example.etstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.ItemBotiquesBinding
import com.example.etstest.modelClass.BotiqueModel
import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.SliderData
import kotlin.collections.ArrayList


class ItemBotique(val binding: ItemBotiquesBinding):
    RecyclerView.ViewHolder(binding.root)

class BotiqueAdapter (val context: Context, val firstList : List<BotiqueModel>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<ItemBotique>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBotique {
        return ItemBotique(
            ItemBotiquesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemBotique, position: Int) {

        val item= firstList[holder.layoutPosition]

        Glide.with(context).load(item.imageUrl).into(holder.binding.imgView)
        holder.binding.text.text= item.name

        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}