package com.example.sopt_26_collaboration.Fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_26_collaboration.CompanyAdapter
import com.example.sopt_26_collaboration.CompanyData

import com.example.sopt_26_collaboration.R
import com.example.sopt_26_collaboration.recyclerview.RecruitAdapter
import com.example.sopt_26_collaboration.recyclerview.RecruitData
import kotlinx.android.synthetic.main.company_item.*
import kotlinx.android.synthetic.main.company_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
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

}
