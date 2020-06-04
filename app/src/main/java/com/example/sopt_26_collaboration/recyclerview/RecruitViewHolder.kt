package com.example.sopt_26_collaboration.recyclerview

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.CompanyData
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.RecruitData
import com.example.sopt_26_collaboration.data.ResponseRecruitData
import com.example.sopt_26_collaboration.network.RequestToServer
import com.example.sopt_26_collaboration.network.customEnqueue
import com.example.sopt_semina_assignment.util.HorizontalItemDecorator
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Integer.parseInt

class RecruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_recruit = itemView.findViewById<ImageView>(R.id.img_recruit)
    val txt_recruit_field = itemView.findViewById<TextView>(R.id.txt_recruit_field)
    val txt_recruit_company = itemView.findViewById<TextView>(R.id.txt_recruit_company)
    val txt_recruit_location = itemView.findViewById<TextView>(R.id.txt_recruit_location)
    val txt_heart_count = itemView.findViewById<TextView>(R.id.txt_heart_count)
    val img_heart = itemView.findViewById<ImageView>(R.id.img_heart)

    fun bind(recruitData: RecruitData) {
        txt_recruit_field.text = recruitData.recruit_position
        txt_recruit_company.text = recruitData.company_name
        txt_recruit_location.text = recruitData.company_location
        txt_heart_count.text = recruitData.company_hearts.toString()
        Glide.with(itemView).load(recruitData.company_img).into(img_recruit)
        heart(recruitData)
    }

    fun heart(recruitData: RecruitData){
        val requestToServer = RequestToServer
        val btn_heart = itemView.findViewById<ConstraintLayout>(R.id.btn_heart)
        var clicked : Boolean = false

        btn_heart.setOnClickListener {
           if(!clicked){
               img_heart.setImageResource(R.drawable.heartred_14px)
               clicked = true

               requestToServer.service.requestHeartUpdate(
                   company_idx = recruitData.company_idx,
                   company_hearts = recruitData.company_hearts+1
               ).customEnqueue(
                   onError = { Log.d("recruit_heart_update","올바르지 못한 요청")},
                   onSuccess = {
                       if(it.success){ //body()가 null이 아니고, success가 true -> 성공
                           txt_heart_count.text = (recruitData.company_hearts+1).toString()
                       }
                   }
               )

           }
            else{
               img_heart.setImageResource(R.drawable.heartgrey_14px)
               clicked = false

               requestToServer.service.requestHeartUpdate(
                   company_idx = recruitData.company_idx,
                   company_hearts = recruitData.company_hearts -1
               ).customEnqueue(
                   onError = { Log.d("recruit_heart_update","올바르지 못한 요청")},
                   onSuccess = {
                       if(it.success){ //body()가 null이 아니고, success가 true -> 성공
                           txt_heart_count.text = (recruitData.company_hearts-1).toString()
                       }
                   }
               )
           }
            
        }
    }
}