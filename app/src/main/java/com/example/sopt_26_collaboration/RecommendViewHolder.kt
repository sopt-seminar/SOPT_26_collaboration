package com.example.sopt_26_collaboration

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_profile = itemView.findViewById<ImageView>(R.id.iv_profile)
    val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
    val tv_company = itemView.findViewById<TextView>(R.id.tv_company)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(recommendPeople: RecommendPeople) {
        img_profile.background = ShapeDrawable(OvalShape())
        img_profile.clipToOutline = true

        Glide.with(itemView).load(recommendPeople.profileImg).into(img_profile)
        tv_name.text = recommendPeople.name
        tv_company.text = recommendPeople.company
    }
}