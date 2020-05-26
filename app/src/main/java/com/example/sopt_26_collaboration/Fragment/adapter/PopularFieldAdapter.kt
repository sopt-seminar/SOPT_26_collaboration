package com.example.sopt_26_collaboration.Fragment.adapter

import android.view.ViewGroup
import com.example.sopt_26_collaboration.Fragment.adapter.viewholder.PopularFieldViewHolder
import com.example.sopt_26_collaboration.Fragment.model.FieldData
import com.example.sopt_26_collaboration.base.BaseAdapter
import com.example.sopt_26_collaboration.base.BaseViewHolder

class PopularFieldAdapter : BaseAdapter<FieldData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFieldViewHolder {
        return PopularFieldViewHolder(parent)
    }
}