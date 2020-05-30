package com.example.sopt_26_collaboration.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.DutyData

class DutyRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<DutyRecyclerViewHolder>() {
    var datas = mutableListOf<DutyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DutyRecyclerViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_duty,parent,false)
        return DutyRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: DutyRecyclerViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}