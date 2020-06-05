package com.example.sopt_26_collaboration

import com.google.gson.annotations.SerializedName

data class RecommendPeople(
    @SerializedName("user_img")
    val profileImg: String,
    @SerializedName("user_name")
    val name: String,
    @SerializedName("user_company")
    val company: String
)