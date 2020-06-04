package com.example.sopt_26_collaboration.recyclerview

import com.google.gson.annotations.SerializedName

data class CompanyData(
    @SerializedName("company_img")
    val companyImg: String,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("company_industry")
    val companyInfo: String,
    @SerializedName("company_follow")
    var companyFollow: Int
) {
    var isFollowed = when (companyFollow) {
        1 -> true
        0 -> false
        else -> null
    } as Boolean
        set(value) {
            companyFollow = when (value) {
                true -> 1
                false -> 0
            }
            field = value
        }
}