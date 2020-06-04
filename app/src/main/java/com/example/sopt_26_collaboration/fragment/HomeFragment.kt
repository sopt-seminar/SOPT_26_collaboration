package com.example.sopt_26_collaboration.fragment

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.sopt_26_collaboration.CompanyAdapter
import com.example.sopt_26_collaboration.CompanyData
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.RecommendAdapter
import com.example.sopt_26_collaboration.RecommendPeople
import com.example.sopt_26_collaboration.network.RequestToServer
import com.example.sopt_26_collaboration.network.response.ResponseRecommendPeople
import com.example.sopt_26_collaboration.recyclerview.RecruitAdapter
import com.example.sopt_26_collaboration.recyclerview.RecruitData
import com.example.sopt_semina_assignment.util.HorizontalItemDecorator
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var bannerImages = intArrayOf(
        R.drawable.carousel_design,
        R.drawable.carousel_android,
        R.drawable.carousel
    )

    private lateinit var recommendAdapter: RecommendAdapter
    private lateinit var companyAdapter: CompanyAdapter
    private lateinit var recruitAdapter: RecruitAdapter

    private var recommendPeople = mutableListOf<RecommendPeople>()
    private val companyDatas = mutableListOf<CompanyData>()
    private val recruitDatas = mutableListOf<RecruitData>()

    private val service = RequestToServer.service

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val subtitleStrings = arrayOf(
            "디자인 인재 영입 중",
            "안드로이드 인재 영입 중",
            "iOS 인재 영입 중"
        )

        //carouselView 기능 구현
        val carouselView = view.findViewById(R.id.carousel) as CarouselView
        carouselView.setImageListener(imageListener)
        carouselView.pageCount = bannerImages.count()

        carouselView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

                tv_subtitle.text = subtitleStrings[position]
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

        recruitAdapter = RecruitAdapter(view.context)
        rv_recruit.adapter = recruitAdapter
        rv_recruit.addItemDecoration(HorizontalItemDecorator(12))
        rv_recruit.addItemDecoration(VerticalItemDecorator(16))
        loadRecruitDatas()
    }

    private fun loadCompanyDatas() {
        companyDatas.apply {
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
            add(
                CompanyData(
                    companyImg = "https://cdn.pixabay.com/photo/2020/04/19/08/17/watercolor-5062356__480.jpg",
                    companyName = "카카오",
                    companyInfo = "IT, 컨텐츠"
                )
            )
        }
        companyAdapter.datas = companyDatas
        companyAdapter.notifyDataSetChanged()
    }

    private fun loadRecruitDatas() {
        recruitDatas.apply {
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
            add(
                RecruitData(
                    recruitImg = "",
                    recruitField = "Front-End 개발자",
                    recruitCompany = "카카오",
                    recruitLocation = "서울•한국"
                )
            )
        }
        recruitAdapter.datas = recruitDatas
        recruitAdapter.notifyDataSetChanged()
    }

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(bannerImages.get(position)) }

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
