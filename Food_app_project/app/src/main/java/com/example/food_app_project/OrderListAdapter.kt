package com.example.food_app_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.data.Order

class OrderListAdapter(private val context: Context, private val dataset: List<Order>): RecyclerView.Adapter<OrderListAdapter.ViewHolder>() {
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemname: TextView = itemView.findViewById(R.id.name_item)
        val itemprice: TextView = itemView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderListAdapter.ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_list, parent, false)
        return OrderListAdapter.ViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemname.text = item.itemname.toString()
        holder.itemprice.text = item.itemprice.toString()
    }
}