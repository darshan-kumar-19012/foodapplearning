package com.example.food_app_project.data

import com.example.food_app_project.R
import com.example.food_app_project.data.Restaurant

class RestaurantSource {
        fun loadRestaurants(): List<Restaurant> {
            return listOf<Restaurant>(
                Restaurant(R.string.Restaurant1,R.drawable.dominos,R.string.Rate1,R.string.Time1,R.string.Cost1,R.string.Desc1),
                Restaurant(R.string.Restaurant2,R.drawable.burgerking,R.string.Rate2,R.string.Time2,R.string.Cost2,R.string.Desc2),
                Restaurant(R.string.Restaurant3,R.drawable.pizzahut,R.string.Rate3,R.string.Time3,R.string.Cost3,R.string.Desc3),
                Restaurant(R.string.Restaurant4,R.drawable.mcdonalds,R.string.Rate4,R.string.Time4,R.string.Cost4,R.string.Desc4),
                Restaurant(R.string.Restaurant5,R.drawable.kfc,R.string.Rate5,R.string.Time5,R.string.Cost5,R.string.Desc4),
                Restaurant(R.string.Restaurant6,R.drawable.mamaspizza,R.string.Rate6,R.string.Time6,R.string.Cost6,R.string.Desc6),
                Restaurant(R.string.Restaurant7,R.drawable.papajohnspizza,R.string.Rate7,R.string.Time7,R.string.Cost7,R.string.Desc7),
            )
        }
}