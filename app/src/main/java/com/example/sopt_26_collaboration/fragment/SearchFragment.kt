package com.example.sopt_26_collaboration.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.data.DutyData
import com.example.sopt_26_collaboration.data.DutyDetailData
import com.example.sopt_26_collaboration.data.ResponseContentData
import com.example.sopt_26_collaboration.network.RequestToServer
import com.example.sopt_26_collaboration.recycler.DutyDetailRecyclerAdapter
import com.example.sopt_26_collaboration.recycler.DutyRecyclerAdapter
import com.example.sopt_semina_assignment.util.HorizontalItemDecorator
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    lateinit var dutyAdapter: DutyRecyclerAdapter
    val requestToServer = RequestToServer
    lateinit var dutyDetailAdapter : DutyDetailRecyclerAdapter
    val duty_datas = mutableListOf<DutyData>()

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

        requestToServer.service.requestContentInfo()
            .enqueue(
                object : Callback<ResponseContentData> {
                    override fun onFailure(call: Call<ResponseContentData>, t: Throwable) {
                        Log.d("통신실패", "${t}")
                    }

                    override fun onResponse(
                        call: Call<ResponseContentData>,
                        response: Response<ResponseContentData>
                    ) {
                        if (response.isSuccessful) {
                            if(response.body()!!.success)
                            {
                                dutyDetailAdapter = DutyDetailRecyclerAdapter(view!!.context, response.body()!!.data)
                                rv_search_duty_detail.adapter = dutyDetailAdapter
                                rv_search_duty_detail.addItemDecoration(VerticalItemDecorator(16))
                                dutyDetailAdapter.notifyDataSetChanged()
                            }

                        }

                    }
                }
            )



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





    }

}
