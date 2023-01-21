package com.example.food_app_project.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.food_app_project.databinding.ActivityOrderTrackingBinding
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import com.example.food_app_project.Ordertrackservice
import com.example.food_app_project.R

class Ordertracking : AppCompatActivity() {
    private lateinit var binding:ActivityOrderTrackingBinding
    private lateinit var imagefood:ImageView
    private lateinit var foodprocess:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderTrackingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        imagefood = binding.imageViewFood
        foodprocess = binding.textViewProcess
        val intent = Intent(this, Ordertrackservice::class.java)
        intent.putExtra("sleepTime",1)
        startService(intent)
    }
    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.food_app_project")
        registerReceiver(myStartedServiceReceiver, intentFilter)
    }

    private val myStartedServiceReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val result = intent.getStringExtra("startServiceResult")
            foodprocess.text=result
            imagefood.setImageResource(R.drawable.fooddelivery)
//            orderdelivered()
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myStartedServiceReceiver)
    }

    fun orderdelivered() {
        try {
            Thread.sleep(5000)
            imagefood.setImageResource(R.drawable.fooddelivery)
//            fragmentManager.beginTransaction()
//                .add(R.id.fragmentContainerView, rating::class.java, null)
//                .setReorderingAllowed(true)
//                .commit()
        } catch (e: InterruptedException) {
        }
    }
}