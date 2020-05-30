package com.example.sopt_26_collaboration.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.DutyDetailData

class DutyDetailRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<DutyDetailRecyclerViewHolder>() {
    var datas = mutableListOf<DutyDetailData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DutyDetailRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv_duty_detail,parent,false)
        return DutyDetailRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: DutyDetailRecyclerViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}