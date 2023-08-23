package com.example.sysarksproject.View.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.location.LocationRequestCompat.Quality
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sysarksproject.Model.Entity
import com.example.sysarksproject.databinding.ItemGoodsBinding

class AddItemAdapter(val context: Context) : RecyclerView.Adapter<AddItemAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: ItemGoodsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemGoodsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = differ.currentList[position]
        with(holder) {
            binding.tvTitle.text = "Goods Name : ${item.Title}"
            binding.tvDesc.text = "Description : ${item.Description}"
            binding.tvQuantity.text = "Quantity : ${item.Quantity}"
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.Id == newItem.Id
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffUtilCallBack)
}