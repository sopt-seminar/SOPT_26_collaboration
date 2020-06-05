package com.example.sopt_26_collaboration

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecommendAdapter(val context: Context) : RecyclerView.Adapter<RecommendViewHolder>() {
    var data = mutableListOf<RecommendPeople>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recommend, parent, false)
        return RecommendViewHolder(view)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.bind(data[position])
    }

}