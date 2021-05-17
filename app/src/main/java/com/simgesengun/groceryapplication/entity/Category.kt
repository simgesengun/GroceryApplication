package com.simgesengun.groceryapplication.entity

import java.io.Serializable

data class Category(var id : Int, var title : String, var picture_name : String) : Serializable{
    var items : List<Item> = listOf()
}