package com.simgesengun.groceryapplication

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import kotlinx.android.synthetic.main.item_card_design.view.*

@BindingAdapter("android:image_resource")
fun setImageResource(imageView: ImageView, image_name: String) {
    val id = imageView.context.resources.getIdentifier(image_name,"drawable",imageView.context.packageName)
    imageView.setImageResource(id)
}

@BindingAdapter("android:set_price")
fun setPrice(textView: TextView, price: Double) {
    textView.text = "$price \u20BA"
}

@BindingAdapter(value = ["android:on_sale", "android:new"], requireAll = false)
fun setTag(imageView: ImageView, is_on_sale: Boolean, is_new: Boolean) {
    if (is_on_sale or is_new){
        if (is_on_sale and is_new){
            imageView.setImageResource(R.drawable.ic_overlay_hot)
        }
        else if (is_new){
            imageView.setImageResource(R.drawable.ic_overlay_new)
        }
        else{
            imageView.setImageResource(R.drawable.ic_overlay_sale)
        }
    }
    else{
        imageView.isEnabled = false
    }
}

@BindingAdapter("android:lowercase")
fun setLowercase(textView: TextView, is_lowercase: Boolean) {
    if (is_lowercase){
        textView.text =  textView.text.toString().toLowerCase()
    }
}
