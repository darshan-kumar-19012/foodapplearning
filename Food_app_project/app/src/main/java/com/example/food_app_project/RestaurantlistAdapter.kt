package com.example.food_app_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.data.Restaurant
import org.w3c.dom.Text


class RestaurantlistAdapter(private val context: Context, private val dataset: List<Restaurant>): RecyclerView.Adapter<RestaurantlistAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(hotelimg :String)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    class ViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val hotelname:TextView = itemView.findViewById(R.id.textView_hotelname)
        val hoteldesc:TextView = itemView.findViewById(R.id.textView_desc)
        val hotelimg:ImageView = itemView.findViewById(R.id.imageView_hotelimg)
        val hotelrating:TextView = itemView.findViewById(R.id.textView_rating)
        val cost:TextView = itemView.findViewById(R.id.textView_cost)
        val hoteltime:TextView = itemView.findViewById(R.id.textView_time)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(hotelname.text.toString())
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_list, parent, false)

        return ViewHolder(adapterLayout,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.hotelname.text = context.resources.getString(item.restaurantname)
        holder.hotelimg.setImageResource(item.restaurantlogo)
        holder.hoteldesc.text = context.resources.getString(item.description)
        holder.hotelrating.text = context.resources.getString(item.rating)
        holder.cost.text = context.resources.getString(item.cost)
        holder.hoteltime.text = context.resources.getString(item.time)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
