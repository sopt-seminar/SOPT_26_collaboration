package com.example.sopt_26_collaboration.recyclerview

import com.google.gson.annotations.SerializedName

data class FollowData(
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("company_follow")
    val companyFollow: Int
)