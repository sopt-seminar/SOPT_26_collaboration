package com.example.sopt_26_collaboration.Fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.CompanyAdapter
import com.example.sopt_26_collaboration.CompanyData
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.RecommendAdapter
import com.example.sopt_26_collaboration.RecommendData
import com.example.sopt_26_collaboration.recyclerview.RecruitAdapter
import com.example.sopt_26_collaboration.recyclerview.RecruitData
import kotlinx.android.synthetic.main.company_item.*
import kotlinx.android.synthetic.main.company_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var carouselView: CarouselView
    var bannerImages = intArrayOf(
        R.drawable.carousel_design,
        R.drawable.carousel_android,
        R.drawable.carousel
    )
    var subtitleStrings = arrayOf(
        "디자인 인재 영입 중",
        "안드로이드 인재 영입 중",
        "iOS 인재 영입 중"
    )
    var recommendData = mutableListOf<RecommendData>()
    lateinit var recommendAdapter : RecommendAdapter
    lateinit var companyAdapter: CompanyAdapter
    lateinit var recruitAdapter: RecruitAdapter
    val companyDatas =  mutableListOf<CompanyData>()
    val recruitDatas = mutableListOf<RecruitData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        companyAdapter = CompanyAdapter(view.context)
        rv_company.adapter = companyAdapter //리사이클러뷰 어댑터를 insta Adapter로 지정
        loadCompanyDatas()

        recruitAdapter = RecruitAdapter(view.context)
        rv_recruit.adapter = recruitAdapter
        loadRecruitDatas()
    }

    private fun loadCompanyDatas(){
        companyDatas.apply{
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

    private fun loadRecruitDatas(){
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tvArray : Array<TextView> = arrayOf(
            view.findViewById(R.id.tv_money),
            view.findViewById(R.id.tv_career),
            view.findViewById(R.id.tv_coworker),
            view.findViewById(R.id.tv_welfare),
            view.findViewById(R.id.tv_distance)
        )

        //carouselView 기능 구현
        carouselView = view.findViewById(R.id.carousel) as CarouselView
        carouselView.setImageListener(imageListener)
        carouselView.pageCount = bannerImages.count()

        carouselView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                tv_subtitle.text = subtitleStrings.get(position)
            }
        })

        //버튼 하나만 선택할 수 있게 동작
        val clickListener =
            View.OnClickListener { v ->
                val curText = v as TextView
                for (i in tvArray) {
                    if(curText == i) curText.isSelected = true
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
            for(i in tvArray) {
                if(i.isSelected) {
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
    }

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(bannerImages.get(position)) }

    private fun loadRecommendData() {
        recommendData.apply {
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
            add(
                RecommendData(
                    img_profile = R.drawable.img_profile, name = "이정연", company = "SOPT"
                )
            )
        }
        recommendAdapter.data = recommendData
        recommendAdapter.notifyDataSetChanged()
    }
}
