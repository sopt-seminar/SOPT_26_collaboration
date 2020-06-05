package com.example.sopt_26_collaboration.fragment

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.sopt_26_collaboration.CompanyAdapter
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.RecommendAdapter
import com.example.sopt_26_collaboration.RecommendPeople
import com.example.sopt_26_collaboration.network.RequestToServer
import com.example.sopt_26_collaboration.network.customEnqueue
import com.example.sopt_26_collaboration.network.response.ResponsePopularCompany
import com.example.sopt_26_collaboration.network.response.ResponseRecommendPeople
import com.example.sopt_26_collaboration.recyclerview.CompanyData
import com.example.sopt_26_collaboration.recyclerview.RecruitAdapter
import com.example.sopt_semina_assignment.util.HorizontalItemDecorator
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    val requestToServer = RequestToServer

    private lateinit var recommendAdapter: RecommendAdapter
    private lateinit var companyAdapter: CompanyAdapter
    private lateinit var recruitAdapter: RecruitAdapter

    private var recommendPeople = mutableListOf<RecommendPeople>()
    private var companyDatas =  mutableListOf<CompanyData>()

    private val service = RequestToServer.service


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvArray: Array<TextView> = arrayOf(
            view.findViewById(R.id.tv_money),
            view.findViewById(R.id.tv_career),
            view.findViewById(R.id.tv_coworker),
            view.findViewById(R.id.tv_welfare),
            view.findViewById(R.id.tv_distance)
        )

        //carouselView 기능 구현
        val carouselView = view.findViewById(R.id.carousel) as CarouselView

        var imageListener =
            ImageListener { position, imageView -> run{
                service.requestPopularCompany().customEnqueue(
                    onError = {},
                    onSuccess = {
                        if(it.success)
                            Glide.with(this).load(it.data[position+1].companyImg).into(imageView)
                    }
                )
            } }
        carouselView.setImageListener(imageListener)

        service.requestPopularCompany().customEnqueue(
            onError = {},
            onSuccess = {
                if(it.success)
                    carouselView.pageCount = it.data.count()-1
            }
        )

        carouselView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                service.requestPopularCompany().customEnqueue(
                    onError = {},
                    onSuccess = {
                        if(it.success) {
                            tv_title.text = it.data[position+1].companyName
                            tv_subtitle.text = it.data[position+1].companyTitle
                        }
                    }
                )
                //tv_subtitle.text = subtitleStrings[position]
            }
        })

        //버튼 하나만 선택할 수 있게 동작
        val clickListener = View.OnClickListener { v ->
            val curText = v as TextView
            for (i in tvArray) {
                if (curText == i) curText.isSelected = true
                else i.isSelected = false
            }
        }

        tv_money.setOnClickListener(clickListener)
        tv_career.setOnClickListener(clickListener)
        tv_coworker.setOnClickListener(clickListener)
        tv_welfare.setOnClickListener(clickListener)
        tv_distance.setOnClickListener(clickListener)
        tv_result.setOnClickListener(clickListener)

        //투표 버튼 눌렀을 때
        tv_result.setOnClickListener {
            for (i in tvArray) {
                if (i.isSelected) {
                    poll_start.visibility = View.GONE
                    poll_result.visibility = View.VISIBLE
                    break
                }
            }
        }

        //추천인 RecyclerView에 어뎁터 연결
        recommendAdapter = RecommendAdapter(view.context)
        rv_recommend.adapter = recommendAdapter
        loadRecommendData()

        companyAdapter = CompanyAdapter(view.context)
        rv_company.adapter = companyAdapter //리사이클러뷰 어댑터를 insta Adapter로 지정
        loadCompanyDatas()

        requestToServer.service.requestRecruitInfo().customEnqueue(
            onError = { Log.d("recruit","올바르지 못한 요청")},
            onSuccess = {
                if(it.success){ //body()가 null이 아니고, success가 true -> 성공
                    recruitAdapter = RecruitAdapter(view!!.context,it.data)
                    rv_recruit.adapter = recruitAdapter
                    rv_recruit.addItemDecoration(HorizontalItemDecorator(12))
                    rv_recruit.addItemDecoration(VerticalItemDecorator(16))
                }
            }
        )
    }

    private fun loadCompanyDatas(){
        service.requestPopularCompany().enqueue(object: Callback<ResponsePopularCompany> {
            override fun onFailure(call: Call<ResponsePopularCompany>, t: Throwable) {
                Log.d("loadComanyDatas()", "Fail to load company. $t")
            }

            override fun onResponse(call: Call<ResponsePopularCompany>, response: Response<ResponsePopularCompany>) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        companyDatas = response.body()!!.data as MutableList<CompanyData>
                    }
                }
                companyAdapter.datas = companyDatas
                companyAdapter.notifyDataSetChanged()
            }

        })
    }

    private fun loadRecommendData() {
        service.getRecommendPeople().enqueue(object : Callback<ResponseRecommendPeople> {
            override fun onResponse(
                call: Call<ResponseRecommendPeople>,
                response: Response<ResponseRecommendPeople>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        recommendPeople = response.body()!!.data as MutableList<RecommendPeople>
                        recommendAdapter.data = recommendPeople
                        recommendAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseRecommendPeople>, t: Throwable) {
                Log.d("loadRecommendData", "Fail to request. $t")
            }
        })
    }
}
