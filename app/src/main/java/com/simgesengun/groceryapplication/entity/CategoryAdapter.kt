package com.simgesengun.groceryapplication.entity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.groceryapplication.databinding.CardDesignBinding
import com.simgesengun.groceryapplication.fragment.HomepageFragmentDirections

class CategoryAdapter (var mContext : Context, var categoryList : List<Category>) : RecyclerView.Adapter<CategoryAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(cardDesignBinding : CardDesignBinding) : RecyclerView.ViewHolder(cardDesignBinding.root){
        var design : CardDesignBinding

        init {
            this.design = cardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)

        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val category = categoryList.get(position)

        holder.design.category = category

        holder.design.cardView.setOnClickListener {
            val nav = HomepageFragmentDirections.toDetails(category)
            Navigation.findNavController(it).navigate(nav)
        }
    }
    

    override fun getItemCount(): Int {
        return categoryList.size
    }
}