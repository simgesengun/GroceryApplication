package com.simgesengun.groceryapplication.entity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.groceryapplication.databinding.AchivementCardDesignBinding

class AchivementAdapter (var mContext : Context, var achivementList : List<Achivement>) : RecyclerView.Adapter<AchivementAdapter.AchivementCardDesignHolder>() {

    inner class AchivementCardDesignHolder(achivementCardDesignBinding: AchivementCardDesignBinding) : RecyclerView.ViewHolder(achivementCardDesignBinding.root){
        var design : AchivementCardDesignBinding

        init {
            this.design = achivementCardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchivementCardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = AchivementCardDesignBinding.inflate(layoutInflater, parent, false)

        return AchivementCardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: AchivementCardDesignHolder, position: Int) {
        val achivement = achivementList.get(position)

        holder.design.achivement = achivement
        holder.design.achivementCardView.setOnClickListener {
            Snackbar.make(it,"${achivement.name} - ${achivement.desc}",Snackbar.LENGTH_SHORT).show()
        }

    }


    override fun getItemCount(): Int {
        return achivementList.size
    }
}