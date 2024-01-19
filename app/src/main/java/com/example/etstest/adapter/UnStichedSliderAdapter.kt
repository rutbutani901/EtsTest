package com.example.etstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.ItemUnstichedBinding
import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.SliderData
import com.example.etstest.modelClass.UnStitchedModel
import kotlin.collections.ArrayList


class UnStichedItemView(val binding: ItemUnstichedBinding):
    RecyclerView.ViewHolder(binding.root)

class UnStichedSliderAdapter (val context: Context, val firstList : List<UnStitchedModel>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<UnStichedItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnStichedItemView {
        return UnStichedItemView(
            ItemUnstichedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UnStichedItemView, position: Int) {

        val item= firstList[holder.layoutPosition]

        Glide.with(context).load(item.imageUrl).into(holder.binding.imgView)
        holder.binding.title.text= item.name
        holder.binding.description.text= item.description

        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}