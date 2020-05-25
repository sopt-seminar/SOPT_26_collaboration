package com.example.sopt_26_collaboration.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.DutyData
import kotlinx.android.synthetic.main.item_rv_duty.*

class DutyRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val img = itemView.findViewById<TextView>(R.id.img_duty)
    val duty = itemView.findViewById<TextView>(R.id.tv_duty)
    val duty_content = itemView.findViewById<TextView>(R.id.tv_duty_content)
    fun bind(Data: DutyData)
    {
        img.setBackgroundColor(Data.img)
        duty.text = Data.text
        duty_content.text = "개발자"
    }
}