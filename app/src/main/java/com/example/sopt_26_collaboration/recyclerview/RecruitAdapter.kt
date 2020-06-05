package com.example.sopt_26_collaboration.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.RecruitData

class RecruitAdapter(private val context: Context, val datas : List<RecruitData>) : RecyclerView.Adapter<RecruitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecruitViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recruit_item,parent,false)
        return RecruitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecruitViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}