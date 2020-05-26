package com.example.sopt_26_collaboration.Fragment.adapter

import android.view.ViewGroup
import com.example.sopt_26_collaboration.Fragment.adapter.viewholder.OtherFieldViewHolder
import com.example.sopt_26_collaboration.Fragment.model.OtherFieldData
import com.example.sopt_26_collaboration.base.BaseAdapter

class OtherFieldAdapter : BaseAdapter<OtherFieldData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherFieldViewHolder {
        return OtherFieldViewHolder(parent)
    }
}