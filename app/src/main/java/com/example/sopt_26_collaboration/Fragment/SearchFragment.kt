package com.example.sopt_26_collaboration.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.Fragment.adapter.PopularFieldAdapter
import com.example.sopt_26_collaboration.Fragment.adapter.decoration.MarginDecoration
import com.example.sopt_26_collaboration.Fragment.model.FieldData

import com.example.sopt_26_collaboration.R
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val popularFieldAdapter: PopularFieldAdapter by lazy { PopularFieldAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fieldList = mutableListOf<FieldData>()
        fieldList.add(FieldData("개발", "#24e0bd"))
        fieldList.add(FieldData("웹 개발자", "#428bff"))
        fieldList.add(FieldData("자바 개발자", "#2c5bf2"))

        recycler_popular_field.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            popularFieldAdapter.setList(fieldList)
            adapter = popularFieldAdapter
            this.addItemDecoration(MarginDecoration(context, 16, RecyclerView.HORIZONTAL))
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
