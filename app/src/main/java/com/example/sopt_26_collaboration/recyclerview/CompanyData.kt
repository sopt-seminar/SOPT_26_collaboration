package com.example.sopt_26_collaboration.recyclerview

import com.google.gson.annotations.SerializedName

data class CompanyData(
    @SerializedName("company_idx")
    val companyId: Int,
    @SerializedName("company_img")
    val companyImg: String,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("company_industry")
    val companyInfo: String,
    @SerializedName("company_follow")
    var companyFollow: Int,
    @SerializedName("carousel_view_title")
    val companyTitle: String?
)