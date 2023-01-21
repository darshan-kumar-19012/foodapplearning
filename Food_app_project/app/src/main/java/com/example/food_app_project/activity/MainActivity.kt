package com.example.food_app_project.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.food_app_project.R
import com.example.food_app_project.RestaurantlistAdapter
import com.example.food_app_project.data.RestaurantSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = RestaurantSource().loadRestaurants()
        val recyclerView = findViewById<RecyclerView>(R.id.restaurantlist)
        val adapter = RestaurantlistAdapter(this, myDataset)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : RestaurantlistAdapter.onItemClickListener {
            override fun onItemClick(hotelname:String) {
                val intent = Intent(this@MainActivity, MenuActivity::class.java)
                intent.putExtra("image",hotelname)
                startActivity(intent)
            }
        })
        recyclerView.setHasFixedSize(true)

    }
}