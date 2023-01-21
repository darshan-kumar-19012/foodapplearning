package com.example.food_app_project.data

import com.example.food_app_project.R

class MenuSource {
    fun loadMenu(): List<Menu> {
        return listOf<Menu>(
            Menu(R.string.itname1, R.string.price1),
            Menu(R.string.itname2, R.string.price2),
            Menu(R.string.itname3, R.string.price3),
            Menu(R.string.itname4, R.string.price4),
            Menu(R.string.itname5, R.string.price5),
            Menu(R.string.itname6, R.string.price6),
            Menu(R.string.itname7, R.string.price7)
        )
    }
}