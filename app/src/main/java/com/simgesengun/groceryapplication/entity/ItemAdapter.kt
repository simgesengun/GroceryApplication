package com.simgesengun.groceryapplication.entity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.databinding.ItemCardDesignBinding

class ItemAdapter (var mContext : Context, var itemList : List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemCardDesignHolder>() {

    inner class ItemCardDesignHolder(itemCardDesignBinding: ItemCardDesignBinding) : RecyclerView.ViewHolder(itemCardDesignBinding.root){
        var design : ItemCardDesignBinding

        init {
            this.design = itemCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = ItemCardDesignBinding.inflate(layoutInflater, parent, false)

        return ItemCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: ItemCardDesignHolder, position: Int) {
        val item = itemList.get(position)

        holder.design.item = item
        holder.design.itemCardView.setOnClickListener {
            Snackbar.make(it, "${item.name} added to cart", Snackbar.LENGTH_SHORT).show()

        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }
}