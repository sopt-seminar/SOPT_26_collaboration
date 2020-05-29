package com.example.sopt_26_collaboration

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img_company = itemView.findViewById<ImageView>(R.id.img_company)
    val txt_company_name = itemView.findViewById<TextView>(R.id.txt_company_name)
    val txt_company_info = itemView.findViewById<TextView>(R.id.txt_company_info)

    fun bind(companyData: CompanyData){
        txt_company_name.text = companyData.companyName
        txt_company_info.text = companyData.companyInfo
        img_company.setImageResource(R.drawable.img_company)
        following()
    }

    fun following() {
        val txt_comany_follow = itemView.findViewById<TextView>(R.id.txt_company_follow)
        txt_comany_follow.setOnClickListener {
            if(txt_comany_follow.text.equals("팔로우")) {
                txt_comany_follow.text = "팔로잉"
                txt_comany_follow.setTextColor(Color.parseColor("#333333"))
                txt_comany_follow.setBackgroundResource(R.drawable.round_button_grey)
            }
            else{
                txt_comany_follow.text = "팔로우"
                txt_comany_follow.setTextColor(Color.parseColor("#ffffff"))
                txt_comany_follow.setBackgroundResource(R.drawable.round_button_blue)
            }
        }

    }

}