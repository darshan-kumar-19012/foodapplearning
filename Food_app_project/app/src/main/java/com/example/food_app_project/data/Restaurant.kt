package com.example.food_app_project.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant (
    @StringRes
    val restaurantname:Int,
    @DrawableRes
    val restaurantlogo:Int,
    @StringRes
    val rating:Int,
    @StringRes
    val time:Int,
    @StringRes
    val cost:Int,
    @StringRes
    val description:Int
)
