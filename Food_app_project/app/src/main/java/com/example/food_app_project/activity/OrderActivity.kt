package com.example.food_app_project.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.OrderListAdapter
import com.example.food_app_project.R
import com.example.food_app_project.data.Order
import com.example.food_app_project.databinding.ActivityOrderPlaceBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderPlaceBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var placeorder:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        val extra:Bundle?  = intent.getBundleExtra("order")
        val orderitem = extra?.getStringArrayList("orderitem")
        val orderprice = extra?.getIntegerArrayList("orderprice")
        val restname = extra?.getString("hotelname")
        val size = extra?.getInt("size")
        super.onCreate(savedInstanceState)
        binding = ActivityOrderPlaceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val hotelimg = binding.imageViewRestimg
        val hotelname = binding.textViewRestname
        placeorder = binding.placeorderButton
        hotelname.text = restname.toString()
        when(restname){
            "Dominos Pizza" -> hotelimg.setImageResource(R.drawable.dominos)
            "Burger King" -> hotelimg.setImageResource(R.drawable.burgerking)
            "Pizza Hut" -> hotelimg.setImageResource(R.drawable.pizzahut)
            "McDonalds" -> hotelimg.setImageResource(R.drawable.mcdonalds)
            "KFC" -> hotelimg.setImageResource(R.drawable.kfc)
            "Mamas Pizza" -> hotelimg.setImageResource(R.drawable.mamaspizza)
            "Papa Johns Pizza" -> hotelimg.setImageResource(R.drawable.papajohnspizza)
            else->hotelimg.setImageResource(R.drawable.dominos)

        }
        val order = mutableListOf<Order>()
        var i =0
        while (i < size!!){
            order.add(Order(orderitem!![i], orderprice!![i]))
            i++
        }
        val order1:List<Order> = order
        recyclerView = binding.recyclerViewOrderlist
        val adapter = OrderListAdapter(this, order1)
        recyclerView.adapter = adapter
        placeorder.setOnClickListener{
            val intent = Intent(this, Ordertracking::class.java)
            startActivity(intent)
        }
    }
}