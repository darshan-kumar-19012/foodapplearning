package com.example.food_app_project.data

import androidx.annotation.StringRes

data class Menu (
    @StringRes
    val itemname:Int,
    @StringRes
    val itemprice:Int
)
data class Order(
    val itemname:String,
    val itemprice: Int
)
