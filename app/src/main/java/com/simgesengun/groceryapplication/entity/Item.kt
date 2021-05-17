package com.simgesengun.groceryapplication.entity

import java.io.Serializable

data class Item (var id : Int, var name : String, var price : Double, var category_id : Int, var is_on_sale : Boolean = false, var is_new : Boolean = false) : Serializable {
}