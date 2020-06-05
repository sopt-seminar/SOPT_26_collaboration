package com.example.sopt_26_collaboration

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.network.RequestToServer
import com.example.sopt_26_collaboration.network.response.ResponseFollowData
import com.example.sopt_26_collaboration.recyclerview.CompanyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        var isFollowed = companyData.companyFollow != 0

        switchFollowState(txt_comany_follow, isFollowed)

        txt_comany_follow.setOnClickListener {
            switchFollowState(txt_comany_follow, !isFollowed)

            companyData.companyFollow = if (companyData.companyFollow == 0) {
                1
            } else {
                0
            }

            val service = RequestToServer.service

            service.requestPutFollow(companyData.companyId, companyData.companyFollow).enqueue(object : Callback<ResponseFollowData> {

                override fun onFailure(call: Call<ResponseFollowData>, t: Throwable) {
                    Toast.makeText(itemView.context.applicationContext, "잠시후 다시 시도해주세요.", Toast.LENGTH_SHORT).show()

                    switchFollowState(txt_comany_follow, !isFollowed)

                    companyData.companyFollow = if (companyData.companyFollow == 0) {
                        1
                    } else {
                        0
                    }
                }

                override fun onResponse(call: Call<ResponseFollowData>, response: Response<ResponseFollowData>) {
                    if (response.isSuccessful) {
                        if (response.body()!!.success) {
                            Log.d("FollowClickListener",
                                "success. ${response.body()!!.data[0].companyName} : ${response.body()!!.data[0].companyFollow}")
                        }
                    }
                }
            })
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