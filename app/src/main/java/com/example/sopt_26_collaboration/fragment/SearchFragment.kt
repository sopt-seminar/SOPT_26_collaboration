package com.example.sopt_26_collaboration.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.DutyData
import com.example.sopt_26_collaboration.data.DutyDetailData
import com.example.sopt_26_collaboration.recycler.DutyDetailRecyclerAdapter
import com.example.sopt_26_collaboration.recycler.DutyRecyclerAdapter
import com.example.sopt_semina_assignment.util.HorizontalItemDecorator
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    lateinit var dutyAdapter: DutyRecyclerAdapter
    lateinit var dutyDetailAdapter : DutyDetailRecyclerAdapter
    val duty_datas = mutableListOf<DutyData>()
    val duty_detail_datas = mutableListOf<DutyDetailData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dutyAdapter  = DutyRecyclerAdapter(view!!.context)
        rv_search_duty.adapter = dutyAdapter
        rv_search_duty.addItemDecoration(HorizontalItemDecorator(16))
        dutyDetailAdapter = DutyDetailRecyclerAdapter(view!!.context)
        rv_search_duty_detail.adapter = dutyDetailAdapter
        rv_search_duty_detail.addItemDecoration(VerticalItemDecorator(16))

        loadDatas()


    }
    fun loadDatas()
    {
        duty_datas.apply {
            add(DutyData(img=R.drawable.an_search_most_1_img, text="서버"))
            add(DutyData(img=R.drawable.an_search_most_2_img, text="ios"))
            add(DutyData(img=R.drawable.an_search_most_3_img, text="웹"))
            add(DutyData(img=R.drawable.an_search_most_1_img, text="안드로이드"))
            add(DutyData(img=R.drawable.an_search_most_3_img, text="자바"))
        }

        dutyAdapter.datas = duty_datas
        dutyAdapter.notifyDataSetChanged()
        duty_detail_datas.apply {
            add(DutyDetailData(img=R.drawable.an_search_content_1_img,duty = "프론트엔드",duty_content = "이직할 때 고려할점"))
            add(DutyDetailData(img=R.drawable.an_search_content_2_img,duty = "ios 개발",duty_content = "가장 중요하게 생각하는 건?"))
            add(DutyDetailData(img=R.drawable.an_search_content_3_img,duty = "자바언어 공부",duty_content = "어떻게 하는게 좋을까?"))
            add(DutyDetailData(img=R.drawable.an_search_content_1_img,duty = "안드로이드 개발",duty_content = "코틀린으로? 자바로?"))

        }
        dutyDetailAdapter.datas = duty_detail_datas
        dutyDetailAdapter.notifyDataSetChanged()


    }

}
