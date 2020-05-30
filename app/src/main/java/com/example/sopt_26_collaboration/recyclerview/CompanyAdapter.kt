package com.example.sopt_26_collaboration

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CompanyAdapter(private val context: Context) : RecyclerView.Adapter<CompanyViewHolder>() {
    var datas = mutableListOf<CompanyData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.company_item,parent,false)
        return CompanyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(datas[position])
    }



}