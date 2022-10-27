package com.android.wisdomleafassignment.ui

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
import com.bumptech.glide.Glide

class DataAdapter : PagingDataAdapter<DataResponseItem, DataAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.itemdata, parent, false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.imageView)!!
        private val id = view.findViewById<TextView>(R.id.id)
        private val author = view.findViewById<TextView>(R.id.author)
        fun bind(data: DataResponseItem) {
            Glide.with(itemView.context).load(data.url).into(image)
            id.setText(data.id.toString())
            author.setText(data.author.toString())
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

}