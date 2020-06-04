package com.example.sopt_26_collaboration

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.recyclerview.CompanyData

class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_company = itemView.findViewById<ImageView>(R.id.img_company)
    val txt_company_name = itemView.findViewById<TextView>(R.id.txt_company_name)
    val txt_company_info = itemView.findViewById<TextView>(R.id.txt_company_info)
    val txt_comany_follow = itemView.findViewById<TextView>(R.id.txt_company_follow)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(companyData: CompanyData){
        txt_company_name.text = companyData.companyName
        txt_company_info.text = companyData.companyInfo
        img_company.background = ShapeDrawable(OvalShape())
        img_company.clipToOutline = true
        Glide.with(img_company).load(companyData.companyImg).into(img_company)

        companyData.isFollowed.let { switchFollowState(txt_comany_follow, it) }

        txt_comany_follow.setOnClickListener {
            switchFollowState(txt_comany_follow, !companyData.isFollowed)

            companyData.isFollowed = !companyData.isFollowed

            //Todo: 변경된 데이터 서버에 업데이트
        }
    }


    private fun switchFollowState(view: TextView, isFollowed: Boolean) {
        if (isFollowed) {
            view.text = "팔로잉"
            view.setTextColor(Color.parseColor("#333333"))
            view.setBackgroundColor(R.drawable.round_button_grey)
        } else {
            view.text = "팔로우"
            view.setTextColor(Color.parseColor("#ffffff"))
            view.setBackgroundResource(R.drawable.round_button_blue)
        }
    }

}