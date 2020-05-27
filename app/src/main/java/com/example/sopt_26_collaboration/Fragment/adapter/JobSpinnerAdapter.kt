package com.example.sopt_26_collaboration.Fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.sopt_26_collaboration.R

class JobSpinnerAdapter(context: Context, item: List<String>) : BaseAdapter() {
    private val inflater : LayoutInflater by lazy { LayoutInflater.from(context) }
    private val data: List<String> = item

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return if (convertView == null) {
            val view = inflater.inflate(R.layout.custom_spinner_top_view, parent, false)
            (view.findViewById(R.id.text_custom_spinner_jop_item) as TextView).text = data[position]
            view
        } else {
            convertView
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return if (convertView == null) {
            val view = inflater.inflate(R.layout.custom_spinner_job_drop_down, parent, false)
            (view.findViewById(R.id.text_spinner_jop_drop_down) as TextView).text = data[position]
            view
        } else {
            convertView
        }
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }

}