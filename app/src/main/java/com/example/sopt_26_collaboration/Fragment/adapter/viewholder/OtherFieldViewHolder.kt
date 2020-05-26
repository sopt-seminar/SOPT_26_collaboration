package com.example.sopt_26_collaboration.Fragment.adapter.viewholder

import android.view.ViewGroup
import com.example.sopt_26_collaboration.Fragment.model.OtherFieldData
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.base.BaseViewHolder
import com.example.sopt_26_collaboration.databinding.OtherFieldItemBinding

class OtherFieldViewHolder(parent: ViewGroup) :
    BaseViewHolder<OtherFieldData, OtherFieldItemBinding>(R.layout.other_field_item, parent) {

    override fun bind(data: OtherFieldData) {
        binding.run {
            imageOtherFieldItem.setImageResource(data.image_id)
            textDescribeOtherFieldItem.text = data.describe
        }
    }
}