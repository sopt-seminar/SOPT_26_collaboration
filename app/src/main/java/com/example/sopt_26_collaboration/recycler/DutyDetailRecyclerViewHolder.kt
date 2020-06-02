package com.example.sopt_26_collaboration.recycler

import android.content.Context
import android.provider.ContactsContract
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.ContentData
import com.example.sopt_26_collaboration.data.DutyDetailData
import kotlinx.android.synthetic.main.item_rv_duty_detail.view.*

class DutyDetailRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    val img = itemView.findViewById<ImageView>(R.id.img_duty_detail)
    val title = itemView.findViewById<TextView>(R.id.tv_duty_detail_1)
    val content = itemView.findViewById<TextView>(R.id.tv_duty_detail_2)
    val img_shadow = itemView.findViewById<ImageView>(R.id.img_shadow)


    fun bind(Data: ContentData)
    {
        Glide.with(itemView).load(Data.contents_img).into(img)
        img_shadow.setImageResource(R.drawable.an_search_contentblur_img)
        title.text= Data.contents_position+","
        content.text = Data.contents_title

    }
}