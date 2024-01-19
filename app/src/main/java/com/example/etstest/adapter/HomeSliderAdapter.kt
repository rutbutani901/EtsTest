package com.example.etstest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etstest.databinding.HomeItemFirstBinding
import com.example.etstest.modelClass.ParentData
import com.example.etstest.modelClass.SliderData
import kotlin.collections.ArrayList


class FirstSliderItemView(val binding: HomeItemFirstBinding):
    RecyclerView.ViewHolder(binding.root)

class HomeSliderAdapter (val context: Context, val firstList : ArrayList<SliderData>,
                        val callback:(position: Int)->Unit): RecyclerView.Adapter<FirstSliderItemView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstSliderItemView {
        return FirstSliderItemView(
            HomeItemFirstBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FirstSliderItemView, position: Int) {

        val item= firstList[holder.layoutPosition]

        Glide.with(context).load(item.imgUrl).into(holder.binding.imgView)
        holder.binding.text.text= item.title

        holder.itemView.setOnClickListener{
            callback.invoke(holder.layoutPosition)
        }

    }

    override fun getItemCount(): Int {
        return firstList.size
    }
}