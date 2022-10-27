package com.android.wisdomleafassignment.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.wisdomleafassignment.R
import com.android.wisdomleafassignment.data.model.DataResponseItem
import com.android.wisdomleafassignment.databinding.ItemdataBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class DataAdapter(val listener : OnItemTap? = null) : PagingDataAdapter<DataResponseItem, DataAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        holder.itemView.setOnClickListener {
            listener?.itemTapped(getItem(position)!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itembinding = ItemdataBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(itembinding)
    }

    class MyViewHolder(val binding : ItemdataBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataResponseItem) {
        binding.apply {
            Picasso.get().load(data.download_url.toString()).into(imageView)
            Log.e("imagepath",data.url)
            id.setText( "Id "+ data.id.toString())
            author.setText("Author "+data.author.toString())
        }


        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<DataResponseItem>() {
        override fun areItemsTheSame(oldItem: DataResponseItem, newItem: DataResponseItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: DataResponseItem, newItem: DataResponseItem): Boolean {
            return oldItem.url == newItem.url
                    && oldItem.url == newItem.url
        }

    }

    interface OnItemTap{
        fun itemTapped(data : DataResponseItem)
    }

}