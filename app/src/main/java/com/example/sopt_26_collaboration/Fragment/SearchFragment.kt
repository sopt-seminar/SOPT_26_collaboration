package com.example.sopt_26_collaboration.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.Fragment.adapter.JobSpinnerAdapter
import com.example.sopt_26_collaboration.Fragment.adapter.OtherFieldAdapter
import com.example.sopt_26_collaboration.Fragment.adapter.PopularFieldAdapter
import com.example.sopt_26_collaboration.Fragment.adapter.decoration.MarginDecoration
import com.example.sopt_26_collaboration.Fragment.model.FieldData
import com.example.sopt_26_collaboration.Fragment.model.OtherFieldData

import com.example.sopt_26_collaboration.R
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private val popularFieldAdapter: PopularFieldAdapter by lazy { PopularFieldAdapter() }
    private val otherFieldAdapter: OtherFieldAdapter by lazy { OtherFieldAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val jobData = mutableListOf("개발", "디자인", "기획")
        val spinnerAdapter = JobSpinnerAdapter(view.context, jobData)
        spinner_field_fragment_search.adapter = spinnerAdapter

        val fieldList = mutableListOf<FieldData>()
        fieldList.add(FieldData("서버\n개발자", "#24e0bd"))
        fieldList.add(FieldData("웹\n개발자", "#428bff"))
        fieldList.add(FieldData("자바\n개발자", "#2c5bf2"))

        val otherFieldList = mutableListOf<OtherFieldData>()
        otherFieldList.add(OtherFieldData("프론트엔드,\n이직할 때 고려할점", R.drawable.an_search_content_1_img))
        otherFieldList.add(OtherFieldData("iOS 개발자,\n가장 중요하게 생각하는 건?", R.drawable.an_search_content_2_img))
        otherFieldList.add(OtherFieldData("어떤 문구가,\n필요하려나?", R.drawable.an_search_content_3_img))

        recycler_popular_field.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            popularFieldAdapter.setList(fieldList)
            adapter = popularFieldAdapter
            this.addItemDecoration(MarginDecoration(context, 16, RecyclerView.HORIZONTAL))
        }

        recycler_other_field.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            otherFieldAdapter.setList(otherFieldList)
            adapter = otherFieldAdapter
            this.addItemDecoration(MarginDecoration(context, 20, RecyclerView.VERTICAL))
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
