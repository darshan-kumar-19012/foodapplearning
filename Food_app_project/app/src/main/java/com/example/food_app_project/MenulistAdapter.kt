package com.example.food_app_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.data.Menu

class MenulistAdapter(private val context: Context, private val dataset: List<Menu>): RecyclerView.Adapter<MenulistAdapter.ViewHolder>() {
    private lateinit var bListener : OnButtonClickListener

    interface OnButtonClickListener{

        fun onItemClick(itemname:String,itemprice:String)
    }

    fun SetOnButtonClickListener(listener: OnButtonClickListener){

        bListener = listener
    }
    class ViewHolder(private val view: View,listener: OnButtonClickListener) : RecyclerView.ViewHolder(view) {
        val itemname:TextView = itemView.findViewById(R.id.textView_itemname)
        val itemprice:TextView = itemView.findViewById(R.id.textView_price)
        val addbutton:Button = itemView.findViewById(R.id.button_add)
        init {
            addbutton.setOnClickListener {
                listener.onItemClick(itemname.text.toString(),itemprice.text.toString())
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_list, parent, false)
        return ViewHolder(adapterLayout,bListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemname.text = context.resources.getString(item.itemname)
        holder.itemprice.text = context.resources.getString(item.itemprice)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}