package com.example.food_app_project.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.MenulistAdapter
import com.example.food_app_project.data.MenuSource
import com.example.food_app_project.data.Order
import com.example.food_app_project.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var cartbutton:Button
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val myDataset = MenuSource().loadMenu()
        val hotelname = intent.getStringExtra("image")
        cartbutton = binding.buttonCart
        cartbutton.visibility = View.INVISIBLE
        recyclerView = binding.menuList
        val adapter = MenulistAdapter(this, myDataset)
        recyclerView.adapter = adapter
        val orderitem = ArrayList<String>()
        val orderprice = ArrayList<Int>()
        val order = ArrayList<Order>()
        adapter.SetOnButtonClickListener(object : MenulistAdapter.OnButtonClickListener {
            override fun onItemClick(itemname: String, itemprice: String) {
                val price = itemprice.drop(3).toInt()
                orderitem.add(itemname)
                orderprice.add(price)
                order.add(Order(itemname,price))
                cartbutton.visibility = View.VISIBLE
            }
        })
        cartbutton.setOnClickListener{
            val intent = Intent(this@MenuActivity, OrderActivity::class.java)
            val bundle = Bundle()
            bundle.putStringArrayList("orderitem",orderitem)
            bundle.putIntegerArrayList("orderprice",orderprice)
            bundle.putInt("size",orderitem.size)
            bundle.putString("hotelname",hotelname)
            intent.putExtra("order",bundle)
            startActivity(intent)
        }
        recyclerView.setHasFixedSize(true)
    }
}


