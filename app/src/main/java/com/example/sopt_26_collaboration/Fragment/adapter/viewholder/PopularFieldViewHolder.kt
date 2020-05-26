package com.example.sopt_26_collaboration.Fragment.adapter.viewholder

import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import com.example.sopt_26_collaboration.Fragment.model.FieldData
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.base.BaseViewHolder
import com.example.sopt_26_collaboration.databinding.PopularFieldItemBinding

class PopularFieldViewHolder(parent: ViewGroup) :
    BaseViewHolder<FieldData, PopularFieldItemBinding>(R.layout.popular_field_item, parent) {

    override fun bind(data: FieldData) {
        binding.run {
            val backgroundShape = layoutFieldItem.background as GradientDrawable
            backgroundShape.setColor(data.colorState)

            textNamePopularFieldItem.text = data.name
        }
    }
}